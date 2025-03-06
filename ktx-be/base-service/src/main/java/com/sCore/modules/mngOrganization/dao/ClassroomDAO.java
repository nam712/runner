
package com.sCore.modules.mngOrganization.dao;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.core.utils.CommonUtil;
import com.sCore.modules.mngOrganization.bo.Classroom;
import com.sCore.modules.mngOrganization.bo.ClassroomForm;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * @author sCore
 * @since 06/11/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface ClassroomDAO extends CRUDDao<Classroom, Long>
{
    /**
     * List all Classroom
     */
    public List<Classroom> findAll();

    default String buildGetDataQuery(ClassroomForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id           ";
        nativeSQL += "       ,code As code         ";
        nativeSQL += "       ,name As name         ";
        nativeSQL += "       ,department_code As departmentCode ";
        nativeSQL += "       ,created_date As createdDate  ";
        nativeSQL += "       ,created_by As createdBy    ";
        nativeSQL += "       ,modified_date As modifiedDate ";
        nativeSQL += "       ,modified_by As modifiedBy   ";
        nativeSQL += "       FROM classroom ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "name");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form ClassroomForm
     * @return List
     */
    default List<Classroom> getAllDataQuery(DfData dfData, ClassroomForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Classroom.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form ClassroomForm
     * @return DataTableResults
     */
    default DataTableResults<Classroom> getDatatables(
            DfData dfData,
            ClassroomForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Classroom.class);
    }
}
