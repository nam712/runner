
package com.sCore.modules.mngOrganization.dao;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.mngOrganization.bo.Employee;
import com.sCore.modules.mngOrganization.bo.EmployeeForm;


/**
 * @author sCore
 * @since 04/03/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface EmployeeDAO extends CRUDDao<Employee, Long>
{

    /**
     * List all Employee
     */
    public List<Employee> findAll();

    default String buildGetDataQuery(EmployeeForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        e.id As id           ";
        nativeSQL += "       ,e.code As code         ";
        nativeSQL += "       ,e.fullname As fullname     ";
        nativeSQL += "       ,e.date_of_birth As dateOfBirth  ";
        nativeSQL += "       ,e.gender As `gender`      ";
        nativeSQL += "       ,e.address As address      ";
        nativeSQL += "       ,e.ethnic As ethnic       ";
        nativeSQL += "       ,e.organization_work As organizationWork ";
        nativeSQL += "       ,e.created_date As createdDate  ";
        nativeSQL += "       ,e.created_by As createdBy    ";
        nativeSQL += "       ,e.is_party_member As isPartyMember ";
        nativeSQL += "       ,e.party_date As partyDate    ";
        nativeSQL += "       ,e.phone_number As phoneNumber         ";
        nativeSQL += "       ,e.modified_date As modifiedDate ";
        nativeSQL += "       ,e.type As type         ";
        nativeSQL += "       ,e.modified_by As modifiedBy   ";
        nativeSQL += "       FROM employee e ";
        String orderBy = " ORDER BY e.code ASC ";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "e.id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "e.code");
        CommonUtil.filter(form.getFullname(), strCondition, paramList, "e.fullname");
        CommonUtil.filter(form.getDateOfBirth(), strCondition, paramList, "e.date_of_birth");
        CommonUtil.filter(form.getGender(), strCondition, paramList, "e.gender");
        CommonUtil.filter(form.getAddress(), strCondition, paramList, "e.address");
        CommonUtil.filter(form.getEthnic(), strCondition, paramList, "e.ethnic");
        CommonUtil.filter(form.getIsPartyMember(), strCondition, paramList, "e.is_party_member");
        CommonUtil.filter(form.getPartyDate(), strCondition, paramList, "e.party_date");
        CommonUtil.filter(form.getType(), strCondition, paramList, "e.type");
        CommonUtil.filter(form.getOrgIds(), strCondition, paramList, "e.organization_work");
        CommonUtil.filter(form.getPhoneNumber(), strCondition, paramList, "e.phone_number");

        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData
     * @param form
     * @return
     */
    default List<Employee> getAllDataQuery(DfData dfData, EmployeeForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Employee.class);
    }

    /**
     * get data by datatable
     *
     * @return
     */
    default DataTableResults<Employee> getDatatables(
            DfData dfData,
            EmployeeForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Employee.class);
    }

    public List<Employee> findByCodeIn(List<String> lst);

    @Query("SELECT t FROM Employee t where LOWER(t.code) = LOWER(:code) AND t.id != :id ")
    List<Employee> findConflictedCode(@Param("code") String code, @Param("id") Long id);

    Employee findFirstByCode(String code);

}
