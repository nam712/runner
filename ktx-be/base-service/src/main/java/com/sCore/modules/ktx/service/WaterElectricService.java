
package com.sCore.modules.ktx.service;

import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.utils.DfData;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.modules.ktx.bo.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.bo.WaterElectric;
import com.sCore.modules.ktx.bo.WaterElectricForm;
import com.sCore.modules.ktx.dao.WaterElectricDAO;

import java.util.List;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Service
public class WaterElectricService extends CRUDService<WaterElectric, WaterElectricForm> {

    @Autowired
    private WaterElectricDAO waterElectricDAO;

        @Override
    public CRUDDao<WaterElectric, Long> getBaseDAO() {
        return waterElectricDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<WaterElectric> getDatatables(WaterElectricForm form) {
        return waterElectricDAO.getDatatables(dfData, form);
    }

    public WaterElectric getNearestWaterElectric(WaterElectricForm form) {
        return waterElectricDAO.getNearestWaterElectric(dfData, form);
    }

    @Override
    protected void validateBeforeSave(WaterElectric entity, WaterElectricForm form) throws ValidateException {
        List<WaterElectric> waterElectrics = waterElectricDAO.findByRoomCodeAndMonthAndYearAndTypeAndIdNot(
                form.getRoomCode(), form.getMonth(), form.getYear(), form.getType(), CommonUtil.NVL(form.getId()));
        if (!CommonUtil.isNullOrEmpty(waterElectrics)) {
            throw new ValidateException("validate.waterElectricDuplicate", "Dữ liệu đã được nhập");
        }
    }
}
