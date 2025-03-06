/*
 * Copyright (C) 2018 Viettel Telecom. All rights reserved. VIETTEL PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */
package com.sCore.modules.settings.categoryType.controller;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.settings.category.controller.CategoryController;
import com.sCore.modules.settings.categoryType.bo.CategoryType;
import com.sCore.modules.settings.categoryType.bo.CategoryTypeForm;
import com.sCore.modules.settings.categoryType.service.CategoryTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sCore
 * @since 01/09/2021
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/category-type")
public class CategoryTypeController extends CRUDController<CategoryType, CategoryTypeForm> {

    @Autowired
    private CategoryTypeService categoryTypeService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryTypeController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CRUDService<CategoryType, CategoryTypeForm> getMainService() {
        return categoryTypeService;
    }

    @Override
    protected Class<CategoryType> getClassEntity() {
        return CategoryType.class;
    }
}
