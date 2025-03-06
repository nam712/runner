
package com.sCore.modules.permission.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.RoleResourceAction;
import com.sCore.modules.permission.bo.RoleResourceActionForm;


/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface RoleResourceActionDAO extends CRUDDao<RoleResourceAction, Long>
{
    /**
     * List all RoleResourceAction
     */
    public List<RoleResourceAction> findAll();

    default String buildGetDataQuery(RoleResourceActionForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        role_code As roleCode     ";
        nativeSQL += "        resource_code As resourceCode ";
        nativeSQL += "        action_code As actionCode   ";
        nativeSQL += "       FROM p_role_resource_action ";
        String orderBy = " ORDER BY role_code DESCresource_code DESCaction_code DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getRoleCode(), strCondition, paramList, "role_code");
        CommonUtil.filter(form.getResourceCode(), strCondition, paramList, "resource_code");
        CommonUtil.filter(form.getActionCode(), strCondition, paramList, "action_code");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form RoleResourceActionForm
     * @return List
     */
    default List<RoleResourceAction> getAllDataQuery(DfData dfData, RoleResourceActionForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, RoleResourceAction.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form RoleResourceActionForm
     * @return DataTableResults
     */
    default DataTableResults<RoleResourceAction> getDatatables(
            DfData dfData,
            RoleResourceActionForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, RoleResourceAction.class);
    }

    List<RoleResourceAction> findByRoleCodeAndResourceCode(String roleCode, String resourceCode);
    List<RoleResourceAction> findByRoleCodeAndResourceCodeIn(String roleCode, List<String> resourceCodeList);

    void deleteByRoleCodeAndResourceCode(String roleCode, String resourceCode);
}
