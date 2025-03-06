
package com.sCore.modules.permission.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.Menu;
import com.sCore.modules.permission.bo.MenuForm;


/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface MenuDAO extends CRUDDao<Menu, Long>
{
    /**
     * List all Menu
     */
    public List<Menu> findAll();

    default String buildGetDataQuery(MenuForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        code As code         ";
        nativeSQL += "       ,name As name         ";
        nativeSQL += "       ,parent_code As parentCode   ";
        nativeSQL += "       ,router_link As routerLink   ";
        nativeSQL += "       ,icon As icon         ";
        nativeSQL += "       FROM p_menu ";
        String orderBy = " ORDER BY code DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "name");
        CommonUtil.filter(form.getParentCode(), strCondition, paramList, "parent_code");
        CommonUtil.filter(form.getRouterLink(), strCondition, paramList, "router_link");
        CommonUtil.filter(form.getIcon(), strCondition, paramList, "icon");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form MenuForm
     * @return List
     */
    default List<Menu> getAllDataQuery(DfData dfData, MenuForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Menu.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form MenuForm
     * @return DataTableResults
     */
    default DataTableResults<Menu> getDatatables(
            DfData dfData,
            MenuForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Menu.class);
    }

    default List<Menu> findByUser(DfData dfData, String username) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = "    " +
                "WITH RECURSIVE cte_name AS (  " +
                "        SELECT  " +
                "          m.id AS id,  " +
                "          m.CODE AS code,  " +
                "          m.NAME AS name,  " +
                "          m.parent_code AS parentCode,  " +
                "          m.router_link AS routerLink,  " +
                "          m.icon AS icon,  " +
                "          m.sort_order AS sortOrder   " +
                "        FROM  " +
                "          p_user u  " +
                "          INNER JOIN p_user_role ur ON u.id = ur.user_id  " +
                "          INNER JOIN p_role r ON r.id = ur.role_id  " +
                "          INNER JOIN p_role_menu rm ON r.CODE = rm.role_code  " +
                "          INNER JOIN p_menu m ON m.CODE = rm.menu_code   " +
                "        WHERE  " +
                "          1 = 1   " +
                "          AND u.username = ?  " +
                "    UNION ALL  " +
                "      select   " +
                "          m1.id AS id,  " +
                "          m1.CODE AS code,  " +
                "          m1.NAME AS name,  " +
                "          m1.parent_code AS parentCode,  " +
                "          m1.router_link AS routerLink,  " +
                "          m1.icon AS icon,  " +
                "          m1.sort_order AS sortOrder   " +
                "      from p_menu m1  " +
                "      join cte_name a on m1.code = a.parentCode  " +
                ")  " +
                "SELECT DISTINCT id, code, name, parentCode, routerLink, icon, sortOrder" +
                "  FROM cte_name ORDER BY sortOrder;";
        paramList.add(username);
        return dfData.list(nativeQuery, paramList, Menu.class);
    }
}
