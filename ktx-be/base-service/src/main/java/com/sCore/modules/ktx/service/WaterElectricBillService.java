
package com.sCore.modules.ktx.service;

import com.sCore.core.exception.ValidateException;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.core.utils.UserUtil;
import com.sCore.modules.ktx.bo.*;
import com.sCore.modules.ktx.dao.RoomDAO;
import com.sCore.modules.ktx.dao.WaterElectricBillDetailDAO;
import com.sCore.modules.ktx.dao.WaterElectricDAO;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.dao.WaterElectricBillDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Service
public class WaterElectricBillService extends CRUDService<WaterElectricBill, WaterElectricBillForm> {

    @Autowired
    private WaterElectricBillDAO waterElectricBillDAO;
    @Autowired
    private WaterElectricBillDetailDAO waterElectricBillDetailDAO;
    @Autowired
    private RoomDAO roomDAO;
    @Autowired
    private WaterElectricDAO waterElectricDAO;

    @Override
    public CRUDDao<WaterElectricBill, Long> getBaseDAO() {
        return waterElectricBillDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<WaterElectricBill> getDatatables(WaterElectricBillForm form) {
        return waterElectricBillDAO.getDatatables(dfData, form);
    }

    public void createBill(WaterElectricBillForm form) {
        List<String> roomCodeList = form.getRoomCodeList();

        List<Room> rooms = roomDAO.findByCodeIn(roomCodeList);
        if (CommonUtil.isNullOrEmpty(rooms)) {
            return;
        }

        List<WaterElectric> waterElectrics = waterElectricDAO.findByRoomCodeInAndMonthAndYear(roomCodeList, form.getMonth(), form.getYear());
        if (CommonUtil.isNullOrEmpty(waterElectrics)) {
            waterElectrics = new ArrayList<>();
        }

        List<WaterElectricBill> waterElectricBills  = waterElectricBillDAO.findByRoomCodeInAndMonthAndYear(roomCodeList, form.getMonth(), form.getYear());
        List<String> billCodeList = waterElectricBills.stream().map(WaterElectricBill::getCode)
                .collect(Collectors.toList());
        waterElectricBillDetailDAO.deleteByBillCodeIn(billCodeList);
        waterElectricBillDAO.deleteAll(waterElectricBills);

        for (Room room : rooms) {
            WaterElectricBill waterElectricBill = new WaterElectricBill();
            waterElectricBill.setCreatedBy(UserUtil.getUserLoginName());
            waterElectricBill.setCreatedDate(new Date());
            waterElectricBill.setRoomCode(room.getCode());
            waterElectricBill.setMonth(form.getMonth());
            waterElectricBill.setYear(form.getYear());
            waterElectricBill.setCode(String.format("HDDN%d%02d%06d", form.getYear(), form.getMonth(), room.getId()));
            waterElectricBill.setTotalMoney(0D);
            waterElectricBill.setStatus("NOT_YET");
            waterElectricBillDAO.save(waterElectricBill);

            List<WaterElectric> list = waterElectrics.stream().filter(x -> x.getRoomCode().equals(room.getCode())).collect(Collectors.toList());
            Double totalMoney = 0D;
            for (WaterElectric waterElectric: list) {
                WaterElectricBillDetail detail = getWaterElectricBillDetail(form, waterElectric, waterElectricBill);
                totalMoney += detail.getMoney();
                waterElectricBillDetailDAO.save(detail);
            }
            waterElectricBill.setTotalMoney(totalMoney);
            waterElectricBillDAO.save(waterElectricBill);
        }
    }


    public WaterElectricBill pay(String billCode) throws ValidateException {
        WaterElectricBill waterElectricBill = waterElectricBillDAO.findFirstByCode(billCode);
        if (waterElectricBill == null) {
            throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Bản ghi không tồn tại");
        }
        waterElectricBill.setStatus("PAID");
        waterElectricBill.setModifiedBy(UserUtil.getUserLoginName());
        waterElectricBill.setModifiedDate(new Date());
        waterElectricBillDAO.save(waterElectricBill);
        return waterElectricBill;
    }
    @NotNull
    private static WaterElectricBillDetail getWaterElectricBillDetail(WaterElectricBillForm form, WaterElectric waterElectric, WaterElectricBill waterElectricBill) {
        WaterElectricBillDetail detail = new WaterElectricBillDetail();
        detail.setBillCode(waterElectricBill.getCode());
        detail.setType(waterElectric.getType());
        detail.setConsumption(waterElectric.getNewNumeral() - waterElectric.getOldNumeral());
        detail.setUnitPrice("WATER".equals(waterElectric.getType()) ? form.getUnitPriceWater() : form.getUnitPriceElectric());
        detail.setMoney(detail.getUnitPrice() * detail.getConsumption());
        detail.setCreatedBy(UserUtil.getUserLoginName());
        detail.setCreatedDate(new Date());
        return detail;
    }

    @Override
    protected void customAfterFindById(WaterElectricBill entity) {
        Room room = roomDAO.findFirstByCode(entity.getRoomCode());
        entity.setRoomName(room != null ? room.getName() : "");
        entity.setDetailList(waterElectricBillDetailDAO.findByBillCode(entity.getCode()));
    }
}
