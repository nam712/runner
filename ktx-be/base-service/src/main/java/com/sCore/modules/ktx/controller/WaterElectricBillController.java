
package com.sCore.modules.ktx.controller;

import com.sCore.core.exception.PermissionException;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.bo.WaterElectricBill;
import com.sCore.modules.ktx.bo.WaterElectricBillForm;
import com.sCore.modules.ktx.service.WaterElectricBillService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/water-electric-bill")
public class WaterElectricBillController extends CRUDController<WaterElectricBill, WaterElectricBillForm> {

    @Autowired
    private WaterElectricBillService waterElectricBillService;

    @Override
    protected CRUDService<WaterElectricBill, WaterElectricBillForm> getMainService() {
        return waterElectricBillService;
    }

    @Override
    protected Class<WaterElectricBill> getClassEntity() {
        return WaterElectricBill.class;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(WaterElectricBillController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }


    @PostMapping(value = "create-bill", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Response createBill(HttpServletRequest request, @RequestBody WaterElectricBillForm form) throws PermissionException {
        LOGGER.info("---- createBill ----");
        waterElectricBillService.createBill(form);
        return Response.success(Constants.RESPONSE_CODE.SUCCESS);
    }


    @PostMapping(value = "pay/{code}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Response pay(HttpServletRequest request, @PathVariable String code) throws PermissionException, ValidateException {
        LOGGER.info(String.format("---- pay %s ----", code));
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(waterElectricBillService.pay(code));
    }
}
