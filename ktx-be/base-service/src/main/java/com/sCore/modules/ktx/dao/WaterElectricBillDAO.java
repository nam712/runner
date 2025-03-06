
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
import com.sCore.modules.ktx.bo.WaterElectricBill;
import com.sCore.modules.ktx.bo.WaterElectricBillForm;


/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface WaterElectricBillDAO extends CRUDDao<WaterElectricBill, Long>
{
    /**
     * List all WaterElectricBill
     */
    public List<WaterElectricBill> findAll();

    default String buildGetDataQuery(WaterElectricBillForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        b.id As id           ";
        nativeSQL += "       ,b.code As code         ";
        nativeSQL += "       ,b.room_code As roomCode     ";
        nativeSQL += "       ,b.month As month        ";
        nativeSQL += "       ,b.year As year         ";
        nativeSQL += "       ,b.total_money As totalMoney   ";
        nativeSQL += "       ,b.status As status   ";
        nativeSQL += "       ,b.created_date As createdDate  ";
        nativeSQL += "       ,b.created_by As createdBy    ";
        nativeSQL += "       ,b.modified_date As modifiedDate ";
        nativeSQL += "       ,b.modified_by As modifiedBy   ";
        nativeSQL += "       ,r.name As roomName   ";
        nativeSQL += "       FROM water_electric_bill b ";
        nativeSQL += "       INNER JOIN room r ON r.code = b.room_code ";
        String orderBy = " ORDER BY b.id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "b.id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "b.code");
        CommonUtil.filter(form.getRoomCode(), strCondition, paramList, "b.room_code");
        CommonUtil.filter(form.getMonth(), strCondition, paramList, "b.month");
        CommonUtil.filter(form.getYear(), strCondition, paramList, "b.year");
        CommonUtil.filter(form.getTotalMoney(), strCondition, paramList, "b.total_money");
        CommonUtil.filter(form.getStatus(), strCondition, paramList, "b.status");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form WaterElectricBillForm
     * @return List
     */
    default List<WaterElectricBill> getAllDataQuery(DfData dfData, WaterElectricBillForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, WaterElectricBill.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form WaterElectricBillForm
     * @return DataTableResults
     */
    default DataTableResults<WaterElectricBill> getDatatables(
            DfData dfData,
            WaterElectricBillForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, WaterElectricBill.class);
    }

    List<WaterElectricBill> findByRoomCodeIn(List<String> roomCodeList);
    WaterElectricBill findFirstByCode(String code);
    List<WaterElectricBill> findByRoomCodeInAndMonthAndYear(List<String> roomCodeList, Integer month, Integer year);
    void deleteByRoomCodeIn(List<String> roomCodeList);
}
