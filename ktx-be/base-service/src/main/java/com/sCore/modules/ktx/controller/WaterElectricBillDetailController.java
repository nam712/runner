
package com.sCore.modules.ktx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.bo.WaterElectricBillDetail;
import com.sCore.modules.ktx.bo.WaterElectricBillDetailForm;
import com.sCore.modules.ktx.service.WaterElectricBillDetailService;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/water-electric-bill-detail")
public class WaterElectricBillDetailController extends CRUDController<WaterElectricBillDetail, WaterElectricBillDetailForm> {

    @Autowired
    private WaterElectricBillDetailService waterElectricBillDetailService;

    @Override
    protected CRUDService<WaterElectricBillDetail, WaterElectricBillDetailForm> getMainService() {
        return waterElectricBillDetailService;
    }

    @Override
    protected Class<WaterElectricBillDetail> getClassEntity() {
        return WaterElectricBillDetail.class;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(WaterElectricBillDetailController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
}
