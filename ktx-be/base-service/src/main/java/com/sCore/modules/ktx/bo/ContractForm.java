
package com.sCore.modules.ktx.bo;

import java.util.Date;

import lombok.Data;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Data
public class ContractForm {

    private Long id;
    private String code;
    private String studentCode;
    private String roomCode;
    private Date fromDate;
    private Date toDate;
    private String status;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
}
