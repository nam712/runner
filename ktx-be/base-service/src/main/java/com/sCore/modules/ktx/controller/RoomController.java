
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
import com.sCore.modules.ktx.bo.Room;
import com.sCore.modules.ktx.bo.RoomForm;
import com.sCore.modules.ktx.service.RoomService;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/room")
public class

RoomController extends CRUDController<Room, RoomForm> {

    @Autowired
    private RoomService roomService;

    @Override
    protected CRUDService<Room, RoomForm> getMainService() {
        return roomService;
    }

    @Override
    protected Class<Room> getClassEntity() {
        return Room.class;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @GetMapping(path = "student")
    public Response getRoomStudent(HttpServletRequest req, @RequestParam String roomCode) throws SysException {
        LOGGER.info("---- getRoomStudent ----");
        return Response.success().withData(roomService.getRoomStudent(roomCode));
    }
}
