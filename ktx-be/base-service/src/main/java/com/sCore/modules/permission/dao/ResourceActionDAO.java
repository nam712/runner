
package com.sCore.modules.permission.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.ResourceAction;
import com.sCore.modules.permission.bo.ResourceActionForm;


/**
 * @author sCore
 * @since 09/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface ResourceActionDAO extends CRUDDao<ResourceAction, Long>
{
    /**
     * List all ResourceAction
     */
    public List<ResourceAction> findAll();

    default String buildGetDataQuery(ResourceActionForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id           ";
        nativeSQL += "       ,resource_code As resourceCode ";
        nativeSQL += "       ,action_code As actionCode   ";
        nativeSQL += "       FROM p_resource_action ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getResourceCode(), strCondition, paramList, "resource_code");
        CommonUtil.filter(form.getActionCode(), strCondition, paramList, "action_code");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form ResourceActionForm
     * @return List
     */
    default List<ResourceAction> getAllDataQuery(DfData dfData, ResourceActionForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, ResourceAction.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form ResourceActionForm
     * @return DataTableResults
     */
    default DataTableResults<ResourceAction> getDatatables(
            DfData dfData,
            ResourceActionForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, ResourceAction.class);
    }

    List<ResourceAction> findByResourceCodeIn(List<String> resourceCodeList);
}
