
package com.sCore.modules.ktx.service;

import com.sCore.core.exception.ValidateException;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.core.utils.UserUtil;
import com.sCore.modules.ktx.bo.*;
import com.sCore.modules.ktx.dao.RoomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.dao.ContractDAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Service
public class ContractService extends CRUDService<Contract, ContractForm> {

    @Autowired
    private ContractDAO contractDAO;

    @Autowired
    private RoomDAO roomDAO;

    @Override
    public CRUDDao<Contract, Long> getBaseDAO() {
        return contractDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Contract> getDatatables(ContractForm form) {
        return contractDAO.getDatatables(dfData, form);
    }

    @Override
    protected void customBeforeSave(Contract entity, ContractForm form) throws ValidateException {
        if (CommonUtil.NVL(entity.getId()).equals(0L)) {
            entity.setStatus("ACTIVE");

            //generate code
            long epochSeconds = System.currentTimeMillis() / 1000;
            String hexValue = Long.toHexString(epochSeconds);
            entity.setCode(String.format("HD%s%s", CommonUtil.convertDateToString(form.getFromDate(), "yyMM"), hexValue.toUpperCase()));
        }
    }

    @Override
    protected void validateBeforeSave(Contract entity, ContractForm form) throws ValidateException {
        if (dfData.duplicate(Contract.class, "id", CommonUtil.NVL(form.getId()), "code", form.getCode())) {
            throw new ValidateException(Constants.RESPONSE_CODE.DUPLICATE_CODE, "Mã đã tồn tại");
        }

        Room room = roomDAO.findFirstByCode(form.getRoomCode());
        if (room == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Bản ghi không tồn tại");
        }

        List<Contract> contracts = contractDAO.findByRoomCodeAndStatus(form.getRoomCode(), "ACTIVE");
        if (CommonUtil.isNullOrEmpty(contracts)) {
            contracts = new ArrayList<>();
        }
        Contract contractSigned = contracts.stream().filter(x -> x.getStudentCode().equals(form.getStudentCode()))
                .findFirst().orElse(null);
        if ((contractSigned == null && contracts.size() == room.getAmount()) || (contractSigned != null && CommonUtil.NVL(form.getId()).equals(0L))) {
            throw new ValidateException("validate.roomNotAvailable", "Phòng đã hết chỗ");
        }

    }

    public Contract cancelContract(String code) throws ValidateException {
        Contract contract = contractDAO.findFirstByCode(code);
        if (contract == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Bản ghi không tồn tại");
        }
        contract.setStatus("INACTIVE");
        contract.setToDate(new Date());
        contract.setModifiedBy(UserUtil.getUserLoginName());
        contract.setModifiedDate(new Date());
        contractDAO.save(contract);
        return contract;
    }
}
