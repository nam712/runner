
package com.sCore.modules.permission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.Menu;
import com.sCore.modules.permission.bo.MenuForm;
import com.sCore.modules.permission.service.MenuService;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/menu")
public class MenuController extends CRUDController<Menu, MenuForm> {

    @Autowired
    private MenuService menuService;

    @Override
    protected CRUDService<Menu, MenuForm> getMainService() {
        return menuService;
    }

    @Override
    protected Class<Menu> getClassEntity() {
        return Menu.class;
    }
}
