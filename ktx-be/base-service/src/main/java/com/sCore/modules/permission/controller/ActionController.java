
package com.sCore.modules.permission.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.permission.bo.Action;
import com.sCore.modules.permission.bo.ActionForm;
import com.sCore.modules.permission.service.ActionService;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/action")
public class ActionController extends CRUDController<Action, ActionForm> {

    @Autowired
    private ActionService actionService;

    @Override
    protected CRUDService<Action, ActionForm> getMainService() {
        return actionService;
    }

    @Override
    protected Class<Action> getClassEntity() {
        return Action.class;
    }
}
