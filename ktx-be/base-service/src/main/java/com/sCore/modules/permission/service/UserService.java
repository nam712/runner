
package com.sCore.modules.permission.service;

import com.sCore.config.ApplicationConfig;
import com.sCore.core.exception.PermissionException;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.core.utils.UserUtil;
import com.sCore.modules.permission.bo.Role;
import com.sCore.modules.permission.bo.UserRole;
import com.sCore.modules.permission.dao.RoleDAO;
import com.sCore.modules.permission.dao.UserRoleDAO;
import com.sCore.modules.permission.dto.UserPermissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.User;
import com.sCore.modules.permission.bo.UserForm;
import com.sCore.modules.permission.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Service
public class UserService extends CRUDService<User, UserForm> {

    @Autowired
    private UserRoleDAO userRoleDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private ApplicationConfig applicationConfig;

    @Autowired
    private UserDAO userDAO;

        @Override
    public CRUDDao<User, Long> getBaseDAO() {
        return userDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<User> getDatatables(UserForm form) {
        DataTableResults<User> dataTableResults = userDAO.getDatatables(dfData, form);
        if (!CommonUtil.isNullOrEmpty(dataTableResults.getData())) {
            List<Long> userIds = dataTableResults.getData().stream().map(User::getId).collect(Collectors.toList());
            List<UserRole> userRoles = userRoleDAO.findByUserIdIn(userIds);
            if (CommonUtil.isNullOrEmpty(userRoles)) {
                return dataTableResults;
            }
            List<Long> roleIds = userRoles.stream().map(UserRole::getRoleId).distinct().collect(Collectors.toList());
            List<Role> roles = roleDAO.findByIdIn(roleIds);
            dataTableResults.getData().forEach(x -> {
                List<Long> _roleIds = userRoles.stream().filter(y -> y.getUserId().equals(x.getId()))
                        .map(UserRole::getRoleId).distinct().collect(Collectors.toList());
                x.setRoles(roles.stream().filter(y -> _roleIds.contains(y.getId())).collect(Collectors.toList()));
            });
        }

        return dataTableResults;
    }


    @Override
    protected void validateBeforeSave(User entity, UserForm form) throws ValidateException {
        Long id = CommonUtil.NVL(form.getId());
        List<User> users = userDAO.findConflictedUser(form.getUsername(), id);
        if (!CommonUtil.isNullOrEmpty(users)) {
            throw new ValidateException(Constants.RESPONSE_CODE.DUPLICATE_USER, "Trùng user");
        }
        if (Objects.equals(CommonUtil.NVL(form.getId()), 0L)) {
            form.setPasswordHash("temp");
        } else {
            form.setPasswordHash(entity.getPasswordHash());
        }
    }

    @Override
    protected void customAfterSave(User entity, UserForm form) throws ValidateException {
        if (Objects.equals(CommonUtil.NVL(form.getId()), 0L)) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            entity.setPasswordHash(encoder.encode(applicationConfig.getDefaultPassword()));
//            entity.setPasswordHash(CommonUtil.encryptPassword(applicationConfig.getDefaultPassword(), entity.getId()));
            userDAO.save(entity);
        }
        // save role
        userRoleDAO.deleteByUserId(entity.getId());

        List<Long> roleIds = form.getRoleIds();
        if (!CommonUtil.isNullOrEmpty(roleIds)) {
            List<UserRole> userRoles = new ArrayList<>();
            for (Long roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(entity.getId());
                userRole.setRoleId(roleId);
                userRoles.add(userRole);
            }
            userRoleDAO.saveAll(userRoles);
        }
    }

    @Override
    protected void customBeforeDelete(User entity) throws ValidateException {
        // xoa user_role
        userRoleDAO.deleteByUserId(entity.getId());
    }

    @Override
    protected void customAfterFindById(User entity) {
        entity.setUserRoles(userRoleDAO.findByUserId(entity.getId()));
    }

    public User findByUsername(String username) {
        return userDAO.findFirstByUsername(username);
    }

    public List<UserPermissionDTO> findUserPermission() {
        String username = UserUtil.getUserLoginName();
        if (CommonUtil.isNullOrEmpty(username)) {
            return null;
        }
        return userDAO.findUserPermission(dfData, username);
    }


    public Boolean resetPassword(Long userId) throws ValidateException, PermissionException {
        checkPermission("UPDATE");
        User user = userDAO.findById(userId).orElse(null);
        if (user == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.USER_NOT_EXISTS, "User không tồn tại");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        user.setPasswordHash(encoder.encode(applicationConfig.getDefaultPassword()));
        userDAO.save(user);

        return true;
    }
}
