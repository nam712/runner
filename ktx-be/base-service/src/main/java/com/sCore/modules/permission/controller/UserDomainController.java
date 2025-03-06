
package com.sCore.modules.permission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.UserDomain;
import com.sCore.modules.permission.bo.UserDomainForm;
import com.sCore.modules.permission.service.UserDomainService;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/user-domain")
public class UserDomainController extends CRUDController<UserDomain, UserDomainForm> {

    @Autowired
    private UserDomainService userDomainService;

    @Override
    protected CRUDService<UserDomain, UserDomainForm> getMainService() {
        return userDomainService;
    }

    @Override
    protected Class<UserDomain> getClassEntity() {
        return UserDomain.class;
    }
}
