
package com.sCore.modules.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.ResourceAction;
import com.sCore.modules.permission.bo.ResourceActionForm;
import com.sCore.modules.permission.dao.ResourceActionDAO;

/**
 * @author sCore
 * @since 09/04/2024
 * @version 1.0
 */
@Service
public class ResourceActionService extends CRUDService<ResourceAction, ResourceActionForm> {

    @Autowired
    private ResourceActionDAO resourceActionDAO;

        @Override
    public CRUDDao<ResourceAction, Long> getBaseDAO() {
        return resourceActionDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<ResourceAction> getDatatables(ResourceActionForm form) {
        return resourceActionDAO.getDatatables(dfData, form);
    }
}
