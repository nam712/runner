
package com.sCore.modules.mngOrganization.controller;

import com.sCore.core.exception.SysException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.mngOrganization.bo.Student;
import com.sCore.modules.mngOrganization.bo.StudentForm;
import com.sCore.modules.mngOrganization.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sCore
 * @since 06/11/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/student")
public class StudentController extends CRUDController<Student, StudentForm> {

    @Autowired
    private StudentService studentService;

    @Override
    protected CRUDService<Student, StudentForm> getMainService() {
        return studentService;
    }

    @Override
    protected Class<Student> getClassEntity() {
        return Student.class;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

}
