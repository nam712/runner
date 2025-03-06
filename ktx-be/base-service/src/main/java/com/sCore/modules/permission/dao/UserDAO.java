
package com.sCore.modules.permission.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;



import com.sCore.modules.permission.dto.UserPermissionDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.User;
import com.sCore.modules.permission.bo.UserForm;


/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface UserDAO extends CRUDDao<User, Long>
{
    /**
     * List all User
     */
    public List<User> findAll();

    default String buildGetDataQuery(UserForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        u.id As id           ";
        nativeSQL += "       ,u.username As username     ";
        nativeSQL += "       ,e.fullname As fullName     ";
        nativeSQL += "       ,u.password_hash As passwordHash ";
        nativeSQL += "       ,u.last_logged As lastLogged   ";
        nativeSQL += "       ,u.created_date As createdDate  ";
        nativeSQL += "       ,u.created_by As createdBy    ";
        nativeSQL += "       ,u.modified_date As modifiedDate ";
        nativeSQL += "       ,u.modified_by As modifiedBy   ";
        nativeSQL += "       FROM p_user u ";
        nativeSQL += "       INNER JOIN employee e ON e.id = u.employee_id  ";
        String orderBy = " ORDER BY u.id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "u.id");
        CommonUtil.filter(form.getUsername(), strCondition, paramList, "u.username");
        CommonUtil.filter(form.getPasswordHash(), strCondition, paramList, "u.password_hash");
        CommonUtil.filter(form.getLastLogged(), strCondition, paramList, "u.last_logged");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form UserForm
     * @return List
     */
    default List<User> getAllDataQuery(DfData dfData, UserForm form) {
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
    default DataTableResults<User> getDatatables(
            DfData dfData,
            UserForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, User.class);
    }

    @Query("SELECT t FROM User t where LOWER(t.username) = LOWER(:username) AND t.id != :id ")
    List<User> findConflictedUser(@Param("username") String username, @Param("id") Long id);

    User findFirstByUsername(String username);


    default List<UserPermissionDTO> findUserPermission(DfData dfData, String username) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = "select   " +
                "u.username as username  " +
                ", concat(rra.resource_code, '__', rra.action_code) as permission  " +
                "from p_user u  " +
                "inner join p_user_role ur on u.id = ur.user_id  " +
                "inner join p_role r on r.id = ur.role_id  " +
                "inner join p_role_resource_action rra on r.code = rra.role_code  " +
                "where 1=1  " +
                "and u.username = ?";
        paramList.add(username);
        return dfData.list(nativeQuery, paramList, UserPermissionDTO.class);
    }
}
