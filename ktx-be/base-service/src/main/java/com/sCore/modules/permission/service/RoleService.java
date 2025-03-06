
package com.sCore.modules.permission.service;

import com.sCore.core.exception.PermissionException;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.exception.PermissionCheckerService;
import com.sCore.modules.permission.bo.*;
import com.sCore.modules.permission.dao.*;
import com.sCore.modules.permission.dto.RoleMenuDTO;
import com.sCore.modules.permission.dto.RoleResourceDTO;
import com.sCore.modules.permission.form.AddRoleResourceForm;
import com.sCore.modules.permission.form.UpdateRoleMenuForm;
import com.sCore.modules.permission.form.UpdateRoleResourceActionForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Service
public class RoleService extends CRUDService<Role, RoleForm> {

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private RoleResourceDAO roleResourceDAO;

    @Autowired
    private ResourceDAO resourceDAO;

    @Autowired
    private ResourceActionDAO resourceActionDAO;

    @Autowired
    private ActionDAO actionDAO;

    @Autowired
    private MenuDAO menuDAO;

    @Autowired
    private RoleMenuDAO roleMenuDAO;

    @Autowired
    private RoleResourceActionDAO roleResourceActionDAO;
    @Autowired
    PermissionCheckerService permissionCheckerService;

    @Override
    protected void checkPermission(String action) throws PermissionException {
        checkPermission("ROLE", action);
    }

    protected void checkPermission(String resource, String action) throws PermissionException {
        permissionCheckerService.check(resource, action);
    }

    @Override
    public CRUDDao<Role, Long> getBaseDAO() {
        return roleDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Role> getDatatables(RoleForm form) {
        return roleDAO.getDatatables(dfData, form);
    }

    @Override
    protected void validateBeforeSave(Role entity, RoleForm form) throws ValidateException {
        Long id = CommonUtil.NVL(form.getId());
        List<Role> classrooms = roleDAO.findConflictedCode(form.getCode(), id);
        if (!CommonUtil.isNullOrEmpty(classrooms)) {
            throw new ValidateException(Constants.RESPONSE_CODE.DUPLICATE_CODE, "Trùng mã");
        }
    }

    public RoleMenuDTO findRoleMenu(Long roleId) {
        RoleMenuDTO dto = new RoleMenuDTO();
        dto.setMenuList(menuDAO.findAll());

        Role role = roleDAO.findById(roleId).orElse(null);
        if (role == null) {
            return dto;
        }
        List<RoleMenu> roleMenus = roleMenuDAO.findByRoleCode(role.getCode());
        if (!CommonUtil.isNullOrEmpty(roleMenus)) {
            dto.setMenuCodeList(roleMenus.stream().map(RoleMenu::getMenuCode).collect(Collectors.toList()));
        }
        return dto;
    }

    public Role saveRoleMenu(HttpServletRequest req, UpdateRoleMenuForm form) throws ValidateException, PermissionException {
        checkPermission("UPDATE");
        Role role = roleDAO.findById(form.getRoleId()).orElse(null);
        if (role == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Bản ghi không tồn tại");
        }
        // xoa ban ghi cu
        roleMenuDAO.deleteByRoleCode(role.getCode());

        // luu
        List<RoleMenu> roleMenus = new ArrayList<>();
        for (String menuCode : form.getMenuCodeList()) {
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRoleCode(role.getCode());
            roleMenu.setMenuCode(menuCode);
            roleMenus.add(roleMenu);
        }
        roleMenuDAO.saveAll(roleMenus);

        return role;
    }

    public Role saveRoleResource(HttpServletRequest req, AddRoleResourceForm form) throws ValidateException, PermissionException {
        checkPermission("UPDATE");
        Role role = roleDAO.findFirstByCode(form.getRoleCode());
        if (role == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Bản ghi không tồn tại");
        }

        List<RoleResource> list = roleResourceDAO.findByRoleCodeAndResourceCode(form.getRoleCode(), form.getResourceCode());
        if (!CommonUtil.isNullOrEmpty(list)) {
            throw new ValidateException(Constants.RESPONSE_CODE.DUPLICATE_ROLE_RESOURCE, "Đã thêm tài nguyên cho vai trò");
        }

        RoleResource roleResource = new RoleResource();
        roleResource.setRoleCode(form.getRoleCode());
        roleResource.setResourceCode(form.getResourceCode());
        roleResourceDAO.save(roleResource);
        return role;
    }
    public Role saveRoleResourceAction(HttpServletRequest req, UpdateRoleResourceActionForm form) throws ValidateException, PermissionException {
        checkPermission("UPDATE");
        Role role = roleDAO.findFirstByCode(form.getRoleCode());
        if (role == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Bản ghi không tồn tại");
        }

        List<RoleResource> roleResourceList = roleResourceDAO.findByRoleCodeAndResourceCode(form.getRoleCode(), form.getResourceCode());
        if (CommonUtil.isNullOrEmpty(roleResourceList)) {
            throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Bản ghi không tồn tại");
        }

        List<String> actionList = form.getActionCodeList() != null ? form.getActionCodeList() : new ArrayList<>();

        // load data trong db
        List<RoleResourceAction> roleResourceActions = roleResourceActionDAO.findByRoleCodeAndResourceCode(form.getRoleCode(), form.getResourceCode());
        if (roleResourceActions == null) {
            roleResourceActions = new ArrayList<>();
        }

        // cac ban ghi xoa
        List<RoleResourceAction> removeList = roleResourceActions.stream().filter(x -> !actionList.contains(x.getActionCode())).collect(Collectors.toList());
        roleResourceActionDAO.deleteAll(removeList);

        // them moi
        List<String> savedList = roleResourceActions.stream().map(RoleResourceAction::getActionCode)
                .distinct().collect(Collectors.toList());
        List<String> newActionList = actionList.stream().filter(x -> !savedList.contains(x))
                .distinct().collect(Collectors.toList());
        if (!CommonUtil.isNullOrEmpty(newActionList)) {
            List<RoleResourceAction> resourceActions = new ArrayList<>();
            for (String actionCode : newActionList) {
                RoleResourceAction roleResourceAction = new RoleResourceAction();
                roleResourceAction.setRoleCode(form.getRoleCode());
                roleResourceAction.setResourceCode(form.getResourceCode());
                roleResourceAction.setActionCode(actionCode);
                resourceActions.add(roleResourceAction);
            }
            roleResourceActionDAO.saveAll(resourceActions);
        }

        return role;
    }

    public RoleResourceDTO findRoleResource(String roleCode) {
        RoleResourceDTO dto = new RoleResourceDTO();
        List<RoleResource>  roleResourceList = roleResourceDAO.findByRoleCode(roleCode);
        if (CommonUtil.isNullOrEmpty(roleResourceList)) {
            return dto;
        }
        // resource
        List<String> resourceCodeList = roleResourceList.stream().map(RoleResource::getResourceCode).collect(Collectors.toList());
        List<Resource> resourceList = resourceDAO.findByCodeIn(resourceCodeList);
        dto.setResourceList(resourceList);

        // action
        List<ResourceAction> resourceActions = resourceActionDAO.findByResourceCodeIn(resourceCodeList);
        List<String> actionCodeList = resourceActions.stream().map(ResourceAction::getActionCode).collect(Collectors.toList());
        List<Action> actionList = actionDAO.findByCodeIn(actionCodeList);

        // role_resource_action
        List<RoleResourceAction> roleResourceActions = roleResourceActionDAO.findByRoleCodeAndResourceCodeIn(roleCode, resourceCodeList);

        dto.setResourceActionList(resourceActions);
        dto.setActionList(actionList);
        dto.setRoleResourceActionList(roleResourceActions);
        return dto;
    }

    public Role deleteRoleResource(String roleCode, String resourceCode) throws ValidateException, PermissionException {
        checkPermission("UPDATE");
        Role role = roleDAO.findFirstByCode(roleCode);
        if (role == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Bản ghi không tồn tại");
        }

        List<RoleResource> roleResourceList = roleResourceDAO.findByRoleCodeAndResourceCode(roleCode, resourceCode);
        if (CommonUtil.isNullOrEmpty(roleResourceList)) {
            throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Bản ghi không tồn tại");
        }

        // remove role_resource_action
        roleResourceActionDAO.deleteByRoleCodeAndResourceCode(roleCode, resourceCode);

        // remove role_resource
        roleResourceDAO.deleteByRoleCodeAndResourceCode(roleCode, resourceCode);

        return role;
    }
}
