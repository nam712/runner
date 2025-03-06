
package com.sCore.modules.ktx.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.ktx.bo.WaterElectricBillDetail;
import com.sCore.modules.ktx.bo.WaterElectricBillDetailForm;


/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface WaterElectricBillDetailDAO extends CRUDDao<WaterElectricBillDetail, Long>
{
    /**
     * List all WaterElectricBillDetail
     */
    public List<WaterElectricBillDetail> findAll();
    public List<WaterElectricBillDetail> findByBillCode(String billCode);

    default String buildGetDataQuery(WaterElectricBillDetailForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id           ";
        nativeSQL += "       ,bill_code As billCode     ";
        nativeSQL += "       ,type As type         ";
        nativeSQL += "       ,consumption As consumption  ";
        nativeSQL += "       ,unit_price As unitPrice    ";
        nativeSQL += "       ,money As money        ";
        nativeSQL += "       ,created_date As createdDate  ";
        nativeSQL += "       ,created_by As createdBy    ";
        nativeSQL += "       ,modified_date As modifiedDate ";
        nativeSQL += "       ,modified_by As modifiedBy   ";
        nativeSQL += "       FROM water_electric_bill_detail ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getBillCode(), strCondition, paramList, "bill_code");
        CommonUtil.filter(form.getType(), strCondition, paramList, "type");
        CommonUtil.filter(form.getConsumption(), strCondition, paramList, "consumption");
        CommonUtil.filter(form.getUnitPrice(), strCondition, paramList, "unit_price");
        CommonUtil.filter(form.getMoney(), strCondition, paramList, "money");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form WaterElectricBillDetailForm
     * @return List
     */
    default List<WaterElectricBillDetail> getAllDataQuery(DfData dfData, WaterElectricBillDetailForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, WaterElectricBillDetail.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form WaterElectricBillDetailForm
     * @return DataTableResults
     */
    default DataTableResults<WaterElectricBillDetail> getDatatables(
            DfData dfData,
            WaterElectricBillDetailForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, WaterElectricBillDetail.class);
    }

    void deleteByBillCodeIn(List<String> billCodeList);
}
