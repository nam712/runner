
package com.sCore.modules.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.UserDomain;
import com.sCore.modules.permission.bo.UserDomainForm;
import com.sCore.modules.permission.dao.UserDomainDAO;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Service
public class UserDomainService extends CRUDService<UserDomain, UserDomainForm> {

    @Autowired
    private UserDomainDAO userDomainDAO;

        @Override
    public CRUDDao<UserDomain, Long> getBaseDAO() {
        return userDomainDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<UserDomain> getDatatables(UserDomainForm form) {
        return userDomainDAO.getDatatables(dfData, form);
    }
}
