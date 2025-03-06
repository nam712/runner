
package com.sCore.modules.permission.bo;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Data
public class UserForm {

    private Long id;
    private Long employeeId;
    private String username;
    private String passwordHash;
    private Date lastLogged;
    private Date createdDate;
    private String createdBy;
    private Date modifiedDate;
    private String modifiedBy;
    private List<Long> roleIds;
}
