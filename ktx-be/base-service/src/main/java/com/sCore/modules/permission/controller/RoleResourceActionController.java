
package com.sCore.modules.permission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.RoleResourceAction;
import com.sCore.modules.permission.bo.RoleResourceActionForm;
import com.sCore.modules.permission.service.RoleResourceActionService;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/role-resource-action")
public class RoleResourceActionController extends CRUDController<RoleResourceAction, RoleResourceActionForm> {

    @Autowired
    private RoleResourceActionService roleResourceActionService;

    @Override
    protected CRUDService<RoleResourceAction, RoleResourceActionForm> getMainService() {
        return roleResourceActionService;
    }

    @Override
    protected Class<RoleResourceAction> getClassEntity() {
        return RoleResourceAction.class;
    }
}
