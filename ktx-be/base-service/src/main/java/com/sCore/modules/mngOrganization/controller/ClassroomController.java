
package com.sCore.modules.mngOrganization.controller;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.mngOrganization.bo.Classroom;
import com.sCore.modules.mngOrganization.bo.ClassroomForm;
import com.sCore.modules.mngOrganization.service.ClassroomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sCore
 * @since 06/11/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/classroom")
public class ClassroomController extends CRUDController<Classroom, ClassroomForm> {

    @Autowired
    private ClassroomService classroomService;

    @Override
    protected CRUDService<Classroom, ClassroomForm> getMainService() {
        return classroomService;
    }

    @Override
    protected Class<Classroom> getClassEntity() {
        return Classroom.class;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassroomController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
}
