
package com.sCore.modules.ktx.service;

import com.sCore.core.exception.ValidateException;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.modules.mngOrganization.bo.Organization;
import com.sCore.modules.mngOrganization.bo.OrganizationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.bo.RoomType;
import com.sCore.modules.ktx.bo.RoomTypeForm;
import com.sCore.modules.ktx.dao.RoomTypeDAO;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Service
public class RoomTypeService extends CRUDService<RoomType, RoomTypeForm> {

    @Autowired
    private RoomTypeDAO roomTypeDAO;

        @Override
    public CRUDDao<RoomType, Long> getBaseDAO() {
        return roomTypeDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<RoomType> getDatatables(RoomTypeForm form) {
        return roomTypeDAO.getDatatables(dfData, form);
    }

    @Override
    protected void validateBeforeSave(RoomType entity, RoomTypeForm form) throws ValidateException {
        if (dfData.duplicate(RoomType.class, "id", CommonUtil.NVL(form.getId()), "code", form.getCode())) {
            throw new ValidateException(Constants.RESPONSE_CODE.DUPLICATE_CODE, "Mã đã tồn tại");
        }
    }
}
