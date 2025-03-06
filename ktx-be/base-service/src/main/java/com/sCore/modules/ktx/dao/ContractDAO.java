
package com.sCore.modules.ktx.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.ktx.bo.Contract;
import com.sCore.modules.ktx.bo.ContractForm;


/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface ContractDAO extends CRUDDao<Contract, Long>
{
    /**
     * List all Contract
     */
    public List<Contract> findAll();
    public Contract findFirstByCode(String code);
    public List<Contract> findByRoomCodeAndStatus(String code, String status);

    default String buildGetDataQuery(ContractForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        c.id As id           ";
        nativeSQL += "       ,c.code As code         ";
        nativeSQL += "       ,c.student_code As studentCode  ";
        nativeSQL += "       ,c.room_code As roomCode     ";
        nativeSQL += "       ,c.from_date As fromDate     ";
        nativeSQL += "       ,c.to_date As toDate       ";
        nativeSQL += "       ,c.status As status       ";
        nativeSQL += "       ,c.created_date As createdDate  ";
        nativeSQL += "       ,c.created_by As createdBy    ";
        nativeSQL += "       ,c.modified_date As modifiedDate ";
        nativeSQL += "       ,c.modified_by As modifiedBy   ";
        nativeSQL += "       ,r.name As roomName   ";
        nativeSQL += "       ,s.fullname As studentFullname   ";
        nativeSQL += "       FROM contract c ";
        nativeSQL += "       INNER JOIN room r ON c.room_code = r.code ";
        nativeSQL += "       INNER JOIN student s ON c.student_code = s.code ";
        String orderBy = " ORDER BY c.id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "c.id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "c.code");
        CommonUtil.filter(form.getStudentCode(), strCondition, paramList, "c.student_code");
        CommonUtil.filter(form.getRoomCode(), strCondition, paramList, "c.room_code");
        CommonUtil.filter(form.getFromDate(), strCondition, paramList, "c.from_date");
        CommonUtil.filter(form.getToDate(), strCondition, paramList, "c.to_date");
        CommonUtil.filterEq(form.getStatus(), strCondition, paramList, "c.status");
        CommonUtil.filter(form.getStudentCode(), strCondition, paramList, "c.student_code");
        CommonUtil.filter(form.getRoomCode(), strCondition, paramList, "c.room_code");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form ContractForm
     * @return List
     */
    default List<Contract> getAllDataQuery(DfData dfData, ContractForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Contract.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form ContractForm
     * @return DataTableResults
     */
    default DataTableResults<Contract> getDatatables(
            DfData dfData,
            ContractForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Contract.class);
    }

}
