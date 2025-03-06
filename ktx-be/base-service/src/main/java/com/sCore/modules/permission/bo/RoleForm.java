
package com.sCore.modules.permission.bo;

import java.util.Date;

import lombok.Data;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Data
public class RoleForm {

    private Long id;
    private String code;
    private String name;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
}
