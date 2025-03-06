
package com.sCore.modules.mngOrganization.controller;

import com.sCore.core.exception.SysException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.mngOrganization.bo.OrgTreNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.modules.mngOrganization.bo.Organization;
import com.sCore.modules.mngOrganization.bo.OrganizationForm;
import com.sCore.modules.mngOrganization.service.OrganizationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author sCore
 * @since 07/10/2023
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/organization")
public class OrganizationController extends CRUDController<Organization, OrganizationForm> {

    @Autowired
    private OrganizationService organizationService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CRUDService<Organization, OrganizationForm> getMainService() {
        return organizationService;
    }

    @Override
    protected Class<Organization> getClassEntity() {
        return Organization.class;
    }

    @GetMapping(path = "init-org-tree")
    public Response getInitOrgTree(HttpServletRequest req) throws SysException {
        LOGGER.info("--- getInitOrgTree ---");
        List<OrgTreNode> lst = organizationService.getInitOrgTree();
        return Response.success().withData(lst);
    }

    @GetMapping(path = "child-org/{parentId}")
    public Response getChildOrg(HttpServletRequest req, @PathVariable Long parentId) throws SysException {
        LOGGER.info("--- getChildOrg ---");
        List<OrgTreNode> lst = organizationService.getChildOrg(parentId);
        return Response.success().withData(lst);
    }

    @GetMapping(path = "get-by-code/{orgCode}")
    public Response getByCode(HttpServletRequest req, @PathVariable String orgCode) throws SysException {
        LOGGER.info("--- getByCode ---");
        Organization org = organizationService.getByCode(orgCode);
        return Response.success().withData(org);
    }
}
