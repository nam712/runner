
package com.sCore.modules.ktx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.bo.WaterElectricBillDetail;
import com.sCore.modules.ktx.bo.WaterElectricBillDetailForm;
import com.sCore.modules.ktx.dao.WaterElectricBillDetailDAO;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Service
public class WaterElectricBillDetailService extends CRUDService<WaterElectricBillDetail, WaterElectricBillDetailForm> {

    @Autowired
    private WaterElectricBillDetailDAO waterElectricBillDetailDAO;

        @Override
    public CRUDDao<WaterElectricBillDetail, Long> getBaseDAO() {
        return waterElectricBillDetailDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<WaterElectricBillDetail> getDatatables(WaterElectricBillDetailForm form) {
        return waterElectricBillDetailDAO.getDatatables(dfData, form);
    }
}
