
package com.sCore.modules.permission.dao;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.core.utils.CommonUtil;
import com.sCore.modules.permission.bo.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface UserRoleDAO extends CRUDDao<UserRole, Long>
{
    /**
     * List all User
     */
    public List<UserRole> findAll();

    default String buildGetDataQuery(UserRoleForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        user_id As userId           ";
        nativeSQL += "       ,role_id As roleId     ";
        nativeSQL += "       FROM p_user_role ";
        String orderBy = " ORDER BY user_id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getUserId(), strCondition, paramList, "user_id");
        CommonUtil.filter(form.getRoleId(), strCondition, paramList, "role_id");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form UserForm
     * @return List
     */
    default List<UserRole> getAllDataQuery(DfData dfData, UserRoleForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, User.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form UserForm
     * @return DataTableResults
     */
    default DataTableResults<UserRole> getDatatables(
            DfData dfData,
            UserRoleForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, UserRole.class);
    }

    void deleteByUserId(Long userId);
    List<UserRole> findByUserId(Long userId);
    List<UserRole> findByUserIdIn(List<Long> userId);
}
