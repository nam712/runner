
package com.sCore.modules.ktx.bo;

import java.util.Date;

import lombok.Data;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Data
public class WaterElectricForm {

    private Long id;
    private Integer month;
    private Integer year;
    private String roomCode;
    private String type;
    private Integer oldNumeral;
    private Integer newNumeral;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
}
