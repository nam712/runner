
package com.sCore.modules.mngOrganization.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author sCore
 * @since 06/11/2024
 * @version 1.0
 */
@Data
public class ClassroomForm {

    private Long id;
    private String code;
    private String name;
    private String departmentCode;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
}
