
package com.sCore.modules.permission.service;

import com.sCore.config.ApplicationConfig;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.modules.permission.bo.User;
import com.sCore.modules.permission.bo.UserForm;
import com.sCore.modules.permission.bo.UserRole;
import com.sCore.modules.permission.bo.UserRoleForm;
import com.sCore.modules.permission.dao.UserDAO;
import com.sCore.modules.permission.dao.UserRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Service
public class UserRoleService extends CRUDService<UserRole, UserRoleForm> {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Autowired
    private UserRoleDAO userRoleDAO;

        @Override
    public CRUDDao<UserRole, Long> getBaseDAO() {
        return userRoleDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<UserRole> getDatatables(UserRoleForm form) {
        return userRoleDAO.getDatatables(dfData, form);
    }

}
