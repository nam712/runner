
package com.sCore.modules.ktx.bo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Data
public class WaterElectricBillDetailForm {

    private Long id;
    private String billCode;
    private String type;
    private Integer consumption;
    private Double unitPrice;
    private Double money;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
}
