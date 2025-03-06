
package com.sCore.modules.ktx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.bo.RoomType;
import com.sCore.modules.ktx.bo.RoomTypeForm;
import com.sCore.modules.ktx.service.RoomTypeService;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/room-type")
public class RoomTypeController extends CRUDController<RoomType, RoomTypeForm> {

    @Autowired
    private RoomTypeService roomTypeService;

    @Override
    protected CRUDService<RoomType, RoomTypeForm> getMainService() {
        return roomTypeService;
    }

    @Override
    protected Class<RoomType> getClassEntity() {
        return RoomType.class;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomTypeController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
}
