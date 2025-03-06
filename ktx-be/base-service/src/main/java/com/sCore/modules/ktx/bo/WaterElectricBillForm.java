
package com.sCore.modules.ktx.bo;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Data
public class WaterElectricBillForm {

    private Long id;
    private String code;
    private String roomCode;
    private Integer month;
    private Integer year;
    private Integer totalMoney;
    private String status;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
    private List<String> roomCodeList;
    private Double unitPriceElectric;
    private Double unitPriceWater;
}
