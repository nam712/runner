
package com.sCore.modules.permission.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.RoleMenu;
import com.sCore.modules.permission.bo.RoleMenuForm;


/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface RoleMenuDAO extends CRUDDao<RoleMenu, Long>
{
    /**
     * List all RoleMenu
     */
    public List<RoleMenu> findAll();

    default String buildGetDataQuery(RoleMenuForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id           ";
        nativeSQL += "       ,role_code As roleCode     ";
        nativeSQL += "       ,menu_code As menuCode     ";
        nativeSQL += "       FROM p_role_menu ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getRoleCode(), strCondition, paramList, "role_code");
        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getMenuCode(), strCondition, paramList, "menu_code");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form RoleMenuForm
     * @return List
     */
    default List<RoleMenu> getAllDataQuery(DfData dfData, RoleMenuForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, RoleMenu.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form RoleMenuForm
     * @return DataTableResults
     */
    default DataTableResults<RoleMenu> getDatatables(
            DfData dfData,
            RoleMenuForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, RoleMenu.class);
    }

    void deleteByRoleCode(String roleCode);

    List<RoleMenu> findByRoleCode(String roleCode);
}
