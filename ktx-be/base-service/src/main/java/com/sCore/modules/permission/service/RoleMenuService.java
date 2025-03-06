
package com.sCore.modules.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.RoleMenu;
import com.sCore.modules.permission.bo.RoleMenuForm;
import com.sCore.modules.permission.dao.RoleMenuDAO;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Service
public class RoleMenuService extends CRUDService<RoleMenu, RoleMenuForm> {

    @Autowired
    private RoleMenuDAO roleMenuDAO;

        @Override
    public CRUDDao<RoleMenu, Long> getBaseDAO() {
        return roleMenuDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<RoleMenu> getDatatables(RoleMenuForm form) {
        return roleMenuDAO.getDatatables(dfData, form);
    }
}
