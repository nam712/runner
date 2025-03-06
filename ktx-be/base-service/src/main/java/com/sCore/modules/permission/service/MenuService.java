
package com.sCore.modules.permission.service;

import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.Menu;
import com.sCore.modules.permission.bo.MenuForm;
import com.sCore.modules.permission.dao.MenuDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Service
public class MenuService extends CRUDService<Menu, MenuForm> {

    @Autowired
    private MenuDAO menuDAO;

        @Override
    public CRUDDao<Menu, Long> getBaseDAO() {
        return menuDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Menu> getDatatables(MenuForm form) {
        return menuDAO.getDatatables(dfData, form);
    }

    public List<Menu> findByUserLogin(HttpServletRequest req) {
        String username = UserUtil.getUserLoginName(req);
        if (CommonUtil.isNullOrEmpty(username)) {
            return null;
        }
        return menuDAO.findByUser(dfData, username);
    }
}
