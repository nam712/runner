
package com.sCore.modules.ktx.controller;

import com.sCore.core.exception.SysException;
import com.sCore.core.resful.bean.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.bo.WaterElectric;
import com.sCore.modules.ktx.bo.WaterElectricForm;
import com.sCore.modules.ktx.service.WaterElectricService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/water-electric")
public class WaterElectricController extends CRUDController<WaterElectric, WaterElectricForm> {

    @Autowired
    private WaterElectricService waterElectricService;

    @Override
    protected CRUDService<WaterElectric, WaterElectricForm> getMainService() {
        return waterElectricService;
    }

    @Override
    protected Class<WaterElectric> getClassEntity() {
        return WaterElectric.class;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(WaterElectricController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @GetMapping(path = "nearest")
    public Response getNearestWaterElectric(HttpServletRequest req, WaterElectricForm form) throws SysException {
        LOGGER.info("---- getNearestWaterElectric ----");
        return Response.success().withData(waterElectricService.getNearestWaterElectric(form));
    }
}
