package com.sCore.modules.auth.controller;

import com.sCore.config.jwt.JwtService;
import com.sCore.core.exception.SysException;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.resful.controller.BaseController;
import com.sCore.core.utils.Constants;
import com.sCore.core.utils.UserUtil;
import com.sCore.modules.auth.dto.LoginResponse;
import com.sCore.modules.auth.form.ChangePasswordForm;
import com.sCore.modules.auth.form.LoginForm;
import com.sCore.modules.auth.services.AuthService;
import com.sCore.modules.permission.bo.User;
import com.sCore.modules.permission.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RestController
@RequestMapping("/v1/auth")
public class AuthController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    @Autowired
    UserService userService;

    @Autowired
    AuthService authenticate;

    @PostMapping("login")
    public Response login(@RequestBody LoginForm loginRequest) throws ValidateException {
        LOGGER.info(String.format("---- Đăng nhập: %s ----", loginRequest.getUsername()));
        return Response.success(Constants.RESPONSE_CODE.LOGIN_SUCCESS).withData(authenticate.authenticate(loginRequest));
//        return ResponseEntity.ok(authenticate.authenticate(loginRequest));
    }

    @GetMapping(path = "user-info")
    public Response getUserInfo(HttpServletRequest req) throws SysException {
        LOGGER.info("---- getUserInfo ----");
        return Response.success().withData(authenticate.getUserInfo(req));
    }

    @PostMapping("change-password")
    public Response changePassword(@RequestBody ChangePasswordForm form) throws ValidateException {
        LOGGER.info("---- Đổi mật khẩu: %s ----");
        return Response.success(Constants.RESPONSE_CODE.CHANGE_PASSWORD_SUCCESS).withData(authenticate.changePassword(form));
//        return ResponseEntity.ok(authenticate.authenticate(loginRequest));
    }
}
