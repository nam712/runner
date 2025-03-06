
package com.sCore.modules.ktx.bo;

import java.util.Date;

import lombok.Data;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Data
public class RoomForm {

    private Long id;
    private String code;
    private String name;
    private String roomTypeCode;
    private Integer amount;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
}
