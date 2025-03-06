
package com.sCore.modules.permission.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.RoleResource;
import com.sCore.modules.permission.bo.RoleResourceForm;


/**
 * @author sCore
 * @since 09/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface RoleResourceDAO extends CRUDDao<RoleResource, Long>
{
    /**
     * List all RoleResource
     */
    public List<RoleResource> findAll();

    default String buildGetDataQuery(RoleResourceForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id           ";
        nativeSQL += "       ,role_code As roleCode     ";
        nativeSQL += "       ,resource_code As resourceCode  ";
        nativeSQL += "       FROM p_role_resource ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getRoleCode(), strCondition, paramList, "role_code");
        CommonUtil.filter(form.getResourceCode(), strCondition, paramList, "resource_code");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form RoleResourceForm
     * @return List
     */
    default List<RoleResource> getAllDataQuery(DfData dfData, RoleResourceForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, RoleResource.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form RoleResourceForm
     * @return DataTableResults
     */
    default DataTableResults<RoleResource> getDatatables(
            DfData dfData,
            RoleResourceForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, RoleResource.class);
    }

    List<RoleResource> findByRoleCodeAndResourceCode(String roleCode, String resourceCode);

    List<RoleResource> findByRoleCode(String roleCode);

    void deleteByRoleCodeAndResourceCode(String roleCode, String resourceCode);
}
