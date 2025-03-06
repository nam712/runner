package com.sCore.modules;

import com.sCore.core.exception.SysException;
import com.sCore.core.resful.bean.Response;
import com.sCore.modules.mngOrganization.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/home")
public class HomeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    EmployeeService employeeService;


    @GetMapping(path = "/api/health-check")
    public @ResponseBody
    Response home(HttpServletRequest req) {
        return Response.success().withData("OK");
    }

}
