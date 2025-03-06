
package com.sCore.modules.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.Resource;
import com.sCore.modules.permission.bo.ResourceForm;
import com.sCore.modules.permission.dao.ResourceDAO;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Service
public class ResourceService extends CRUDService<Resource, ResourceForm> {

    @Autowired
    private ResourceDAO resourceDAO;

        @Override
    public CRUDDao<Resource, Long> getBaseDAO() {
        return resourceDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Resource> getDatatables(ResourceForm form) {
        return resourceDAO.getDatatables(dfData, form);
    }
}
