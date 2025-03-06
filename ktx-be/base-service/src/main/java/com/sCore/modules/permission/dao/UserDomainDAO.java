
package com.sCore.modules.permission.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.UserDomain;
import com.sCore.modules.permission.bo.UserDomainForm;


/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface UserDomainDAO extends CRUDDao<UserDomain, Long>
{
    /**
     * List all UserDomain
     */
    public List<UserDomain> findAll();

    default String buildGetDataQuery(UserDomainForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        user_id As userId       ";
        nativeSQL += "        domain As domain       ";
        nativeSQL += "       FROM p_user_domain ";
        String orderBy = " ORDER BY user_id DESCdomain DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getUserId(), strCondition, paramList, "user_id");
        CommonUtil.filter(form.getDomain(), strCondition, paramList, "domain");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form UserDomainForm
     * @return List
     */
    default List<UserDomain> getAllDataQuery(DfData dfData, UserDomainForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, UserDomain.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form UserDomainForm
     * @return DataTableResults
     */
    default DataTableResults<UserDomain> getDatatables(
            DfData dfData,
            UserDomainForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, UserDomain.class);
    }
}
