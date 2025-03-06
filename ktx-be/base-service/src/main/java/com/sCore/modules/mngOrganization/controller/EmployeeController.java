
package com.sCore.modules.mngOrganization.controller;

import com.sCore.core.exception.PermissionException;
import com.sCore.core.exception.SysException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.core.utils.Constants;
import com.sCore.modules.auth.controller.AuthController;
import com.sCore.utils.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import com.sCore.modules.mngOrganization.bo.Employee;
import com.sCore.modules.mngOrganization.bo.EmployeeForm;
import com.sCore.modules.mngOrganization.service.EmployeeService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sCore
 * @since 07/10/2023
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/employee")
public class EmployeeController extends CRUDController<Employee, EmployeeForm> {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Override
    protected CRUDService<Employee, EmployeeForm> getMainService() {
        return employeeService;
    }

    @Override
    protected Class<Employee> getClassEntity() {
        return Employee.class;
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @RequestMapping(value = "get-template-import", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getTemplateImport() throws Exception {
        LOGGER.info("---- getTemplateImport ----");
        return ResponseUtils.getResponseFileEntity(employeeService.getTemplateImport());
    }

    @PostMapping(value = "import", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public Response importWorkScheduleDetail(HttpServletRequest request, Authentication authentication,
                                             @RequestPart(value = "file") MultipartFile file) throws Exception, PermissionException {
        LOGGER.info("---- importWorkScheduleDetail ----");
        return employeeService.importEmployee(request, file, authentication);
    }
}
