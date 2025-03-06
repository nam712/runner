
package com.sCore.modules.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.RoleResource;
import com.sCore.modules.permission.bo.RoleResourceForm;
import com.sCore.modules.permission.dao.RoleResourceDAO;

/**
 * @author sCore
 * @since 09/04/2024
 * @version 1.0
 */
@Service
public class RoleResourceService extends CRUDService<RoleResource, RoleResourceForm> {

    @Autowired
    private RoleResourceDAO roleResourceDAO;

        @Override
    public CRUDDao<RoleResource, Long> getBaseDAO() {
        return roleResourceDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<RoleResource> getDatatables(RoleResourceForm form) {
        return roleResourceDAO.getDatatables(dfData, form);
    }
}
