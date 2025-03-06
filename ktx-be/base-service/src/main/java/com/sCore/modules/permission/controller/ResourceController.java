
package com.sCore.modules.permission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.Resource;
import com.sCore.modules.permission.bo.ResourceForm;
import com.sCore.modules.permission.service.ResourceService;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/resource")
public class ResourceController extends CRUDController<Resource, ResourceForm> {

    @Autowired
    private ResourceService resourceService;

    @Override
    protected CRUDService<Resource, ResourceForm> getMainService() {
        return resourceService;
    }

    @Override
    protected Class<Resource> getClassEntity() {
        return Resource.class;
    }
}
