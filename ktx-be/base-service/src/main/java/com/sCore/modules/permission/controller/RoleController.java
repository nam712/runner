
package com.sCore.modules.permission.controller;

import com.sCore.core.exception.SysException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.utils.Constants;
import com.sCore.modules.mngOrganization.controller.EmployeeController;
import com.sCore.modules.permission.form.AddRoleResourceForm;
import com.sCore.modules.permission.form.UpdateRoleMenuForm;
import com.sCore.modules.permission.form.UpdateRoleResourceActionForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.Role;
import com.sCore.modules.permission.bo.RoleForm;
import com.sCore.modules.permission.service.RoleService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/role")
public class RoleController extends CRUDController<Role, RoleForm> {

    @Autowired
    private RoleService roleService;
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CRUDService<Role, RoleForm> getMainService() {
        return roleService;
    }

    @Override
    protected Class<Role> getClassEntity() {
        return Role.class;
    }

    @GetMapping(path = "role-menu")
    public Response findRoleMenu(HttpServletRequest req, @RequestParam Long roleId) throws SysException {
        LOGGER.info("---- findRoleMenu ----");
        return Response.success().withData(roleService.findRoleMenu(roleId));
    }

    @PostMapping(path = "role-menu")
    public Response saveRoleMenu(HttpServletRequest req, @RequestBody UpdateRoleMenuForm form) throws SysException {
        LOGGER.info("---- saveRoleMenu ----");
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(roleService.saveRoleMenu(req, form));
    }

    @GetMapping(path = "role-resource")
    public Response findRoleResource(HttpServletRequest req, @RequestParam String roleCode) throws SysException {
        LOGGER.info("---- findRoleResource ----");
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(roleService.findRoleResource(roleCode));
    }

    @DeleteMapping(path = "role-resource/{roleCode}/{resourceCode}")
    public Response deleteRoleResource(HttpServletRequest req, @PathVariable String roleCode, @PathVariable String resourceCode) throws SysException {
        LOGGER.info("---- deleteRoleResource ----");
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(roleService.deleteRoleResource(roleCode, resourceCode));
    }

    @PostMapping(path = "role-resource")
    public Response saveRoleResource(HttpServletRequest req, @RequestBody AddRoleResourceForm form) throws SysException {
        LOGGER.info("---- saveRoleResource ----");
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(roleService.saveRoleResource(req, form));
    }
    @PostMapping(path = "role-resource-action")
    public Response saveRoleResourceAction(HttpServletRequest req, @RequestBody UpdateRoleResourceActionForm form) throws SysException {
        LOGGER.info("---- saveRoleResourceAction ----");
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(roleService.saveRoleResourceAction(req, form));
    }
}
