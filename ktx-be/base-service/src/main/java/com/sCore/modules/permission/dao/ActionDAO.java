
package com.sCore.modules.permission.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.Action;
import com.sCore.modules.permission.bo.ActionForm;


/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface ActionDAO extends CRUDDao<Action, Long>
{
    /**
     * List all Action
     */
    public List<Action> findAll();

    default String buildGetDataQuery(ActionForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        code As code         ";
        nativeSQL += "       ,name As name         ";
        nativeSQL += "       FROM p_action ";
        String orderBy = " ORDER BY code DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "name");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form ActionForm
     * @return List
     */
    default List<Action> getAllDataQuery(DfData dfData, ActionForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Action.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form ActionForm
     * @return DataTableResults
     */
    default DataTableResults<Action> getDatatables(
            DfData dfData,
            ActionForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Action.class);
    }

    List<Action> findByCodeIn(List<String> codeList);
}
