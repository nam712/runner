
package com.sCore.modules.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.RoleResourceAction;
import com.sCore.modules.permission.bo.RoleResourceActionForm;
import com.sCore.modules.permission.dao.RoleResourceActionDAO;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Service
public class RoleResourceActionService extends CRUDService<RoleResourceAction, RoleResourceActionForm> {

    @Autowired
    private RoleResourceActionDAO roleResourceActionDAO;

        @Override
    public CRUDDao<RoleResourceAction, Long> getBaseDAO() {
        return roleResourceActionDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<RoleResourceAction> getDatatables(RoleResourceActionForm form) {
        return roleResourceActionDAO.getDatatables(dfData, form);
    }
}
