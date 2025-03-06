
package com.sCore.modules.permission.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.Role;
import com.sCore.modules.permission.bo.RoleForm;


/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface RoleDAO extends CRUDDao<Role, Long>
{
    /**
     * List all Role
     */
    public List<Role> findAll();

    default String buildGetDataQuery(RoleForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id         ";
        nativeSQL += "       ,code As code         ";
        nativeSQL += "       ,name As name         ";
        nativeSQL += "       ,created_date As createdDate  ";
        nativeSQL += "       ,created_by As createdBy    ";
        nativeSQL += "       ,modified_date As modifiedDate ";
        nativeSQL += "       ,modified_by As modifiedBy   ";
        nativeSQL += "       FROM p_role ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "name");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form RoleForm
     * @return List
     */
    default List<Role> getAllDataQuery(DfData dfData, RoleForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Role.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form RoleForm
     * @return DataTableResults
     */
    default DataTableResults<Role> getDatatables(
            DfData dfData,
            RoleForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Role.class);
    }

    @Query("SELECT t FROM Role t where LOWER(t.code) = LOWER(:code) AND t.id != :id ")
    List<Role> findConflictedCode(@Param("code") String code, @Param("id") Long id);

    Role findFirstByCode(String code);
    List<Role> findByIdIn(List<Long> ids);
}
