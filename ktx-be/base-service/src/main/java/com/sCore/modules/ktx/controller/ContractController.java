
package com.sCore.modules.ktx.controller;

import com.sCore.core.exception.PermissionException;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.bo.Contract;
import com.sCore.modules.ktx.bo.ContractForm;
import com.sCore.modules.ktx.service.ContractService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/contract")
public class ContractController extends CRUDController<Contract, ContractForm> {

    @Autowired
    private ContractService contractService;

    @Override
    protected CRUDService<Contract, ContractForm> getMainService() {
        return contractService;
    }

    @Override
    protected Class<Contract> getClassEntity() {
        return Contract.class;
    }
    private static final Logger LOGGER = LoggerFactory.getLogger(ContractController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    @PostMapping(value = "cancel/{code}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public Response cancelContract(HttpServletRequest request, @PathVariable String code) throws PermissionException, ValidateException {
        LOGGER.info("---- cancelContract ----");
        return Response.success(Constants.RESPONSE_CODE.SUCCESS).withData(contractService.cancelContract(code));
    }
}
