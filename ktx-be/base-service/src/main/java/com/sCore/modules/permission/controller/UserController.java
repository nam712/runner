
package com.sCore.modules.permission.controller;

import com.sCore.core.exception.SysException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.User;
import com.sCore.modules.permission.bo.UserForm;
import com.sCore.modules.permission.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/user")
public class UserController extends CRUDController<User, UserForm> {

    @Autowired
    private UserService userService;

    @Override
    protected CRUDService<User, UserForm> getMainService() {
        return userService;
    }

    @Override
    protected Class<User> getClassEntity() {
        return User.class;
    }


    @PostMapping(path = "reset-password/{userId}")
    public Response resetPassword(HttpServletRequest req, @PathVariable Long userId) throws SysException {
        LOGGER.info("---- resetPassword ----");
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(userService.resetPassword(userId));
    }
}
