
package com.sCore.modules.permission.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.Action;
import com.sCore.modules.permission.bo.ActionForm;
import com.sCore.modules.permission.dao.ActionDAO;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Service
public class ActionService extends CRUDService<Action, ActionForm> {

    @Autowired
    private ActionDAO actionDAO;

        @Override
    public CRUDDao<Action, Long> getBaseDAO() {
        return actionDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Action> getDatatables(ActionForm form) {
        return actionDAO.getDatatables(dfData, form);
    }
}
