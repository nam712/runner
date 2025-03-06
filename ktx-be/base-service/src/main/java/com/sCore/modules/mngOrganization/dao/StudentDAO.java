
package com.sCore.modules.mngOrganization.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.sCore.modules.mngOrganization.bo.Student;
import com.sCore.modules.mngOrganization.bo.StudentForm;
import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;


/**
 * @author sCore
 * @since 06/11/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface StudentDAO extends CRUDDao<Student, Long>
{
    /**
     * List all Student
     */
    public List<Student> findAll();

    default String buildGetDataQuery(StudentForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id           ";
        nativeSQL += "       ,code As code         ";
        nativeSQL += "       ,fullname As fullname     ";
        nativeSQL += "       ,first_name As firstName    ";
        nativeSQL += "       ,last_name As lastName     ";
        nativeSQL += "       ,date_of_birth As dateOfBirth  ";
        nativeSQL += "       ,address As address      ";
        nativeSQL += "       ,gender As gender       ";
        nativeSQL += "       ,phone_number As phoneNumber       ";
        nativeSQL += "       ,classroom_code As classroomCode ";
        nativeSQL += "       ,created_date As createdDate  ";
        nativeSQL += "       ,created_by As createdBy    ";
        nativeSQL += "       ,modified_date As modifiedDate ";
        nativeSQL += "       ,modified_by As modifiedBy   ";
        nativeSQL += "       FROM student ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getFullname(), strCondition, paramList, "fullname");
        CommonUtil.filter(form.getFirstName(), strCondition, paramList, "first_name");
        CommonUtil.filter(form.getLastName(), strCondition, paramList, "last_name");
        CommonUtil.filter(form.getDateOfBirth(), strCondition, paramList, "date_of_birth");
        CommonUtil.filter(form.getAddress(), strCondition, paramList, "address");
        CommonUtil.filter(form.getGender(), strCondition, paramList, "gender");
        CommonUtil.filter(form.getClassroomCode(), strCondition, paramList, "classroom_code");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form StudentForm
     * @return List
     */
    default List<Student> getAllDataQuery(DfData dfData, StudentForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Student.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form StudentForm
     * @return DataTableResults
     */
    default DataTableResults<Student> getDatatables(
            DfData dfData,
            StudentForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Student.class);
    }

    public List<Student> findByCodeIn(List<String> lst);

    public Student findFirstByCode(String code);
}
