package com.sCore.modules.auth.services;

import com.sCore.config.jwt.JwtService;
import com.sCore.core.exception.PermissionException;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.core.utils.UserUtil;
import com.sCore.modules.auth.dto.LoginResponse;
import com.sCore.modules.auth.dto.MenuDTO;
import com.sCore.modules.auth.dto.UserInfoDTO;
import com.sCore.modules.auth.form.ChangePasswordForm;
import com.sCore.modules.auth.form.LoginForm;
import com.sCore.modules.mngOrganization.bo.Employee;
import com.sCore.modules.mngOrganization.dao.EmployeeDAO;
import com.sCore.modules.mngOrganization.service.EmployeeService;
import com.sCore.modules.permission.bo.Menu;
import com.sCore.modules.permission.bo.User;
import com.sCore.modules.permission.dao.MenuDAO;
import com.sCore.modules.permission.dao.UserDAO;
import com.sCore.modules.permission.dto.UserPermissionDTO;
import com.sCore.modules.permission.service.MenuService;
import com.sCore.modules.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private UserService userService;

    @Autowired
    JwtService jwtService;

    public LoginResponse authenticate(LoginForm input) throws ValidateException {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getUsername(),
                        input.getPassword()
                )
        );

        User user = userDAO.findFirstByUsername(input.getUsername());
        if (user == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.USER_NOT_EXISTS, "User không tồn tại");
        }
        String jwtToken = jwtService.generateToken(user);

//        // thông tin user
//        Employee employee = employeeService.findByCode(input.getUsername());

        user.setLastLogged(new Date());
        userDAO.save(user);

        return LoginResponse.builder()
                .token(jwtToken)
                .expiresIn(jwtService.getExpirationTime())
                .build();

    }

    public UserInfoDTO getUserInfo(HttpServletRequest req) throws ValidateException, PermissionException {
        String username = UserUtil.getUserLoginName(req);
        if (CommonUtil.isNullOrEmpty(username)) {
            throw new ValidateException(Constants.RESPONSE_CODE.INVALID_PERMISSION, "Không có quyền thực hiện thao tác");
        }
        User user = userDAO.findFirstByUsername(username);
        if (user == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.USER_NOT_EXISTS, "User không tồn tại");
        }
        Employee employee = employeeService.findById(user.getEmployeeId());

        // lay menu
        List<Menu> menuList = menuService.findByUserLogin(req);
        List<MenuDTO> menuDTOS = new ArrayList<>();
        if (!CommonUtil.isNullOrEmpty(menuList)) {
            menuDTOS = menuList.stream().map(MenuDTO::new).collect(Collectors.toList());
        }

        // lay quyen
        List<UserPermissionDTO> userPermissionDTOS = userService.findUserPermission();

        return UserInfoDTO.builder()
                .user(employee)
                .menuList(menuDTOS)
                .userPermissionList(userPermissionDTOS)
                .build();
    }

    public Boolean changePassword(ChangePasswordForm form) throws ValidateException {
        String username = UserUtil.getUserLoginName();
        if (CommonUtil.isNullOrEmpty(username)) {
            throw new ValidateException(Constants.RESPONSE_CODE.INVALID_PERMISSION, "Không có quyền thực hiện thao tác");
        }
        User user = userDAO.findFirstByUsername(username);
        if (user == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.USER_NOT_EXISTS, "User không tồn tại");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String passwordHash = encoder.encode(form.getCurrentPassword());
        if (!encoder.matches(form.getCurrentPassword(), user.getPasswordHash())) {
            throw new ValidateException(Constants.RESPONSE_CODE.PASSWORD_INCORRECT, "Mật khẩu không chính xác");
        }

        user.setPasswordHash(encoder.encode(form.getNewPassword()));
        userDAO.save(user);

        return true;
    }
}
