
package com.sCore.modules.mngOrganization.bo;

import java.util.Date;

import lombok.Data;

/**
 * @author sCore
 * @since 07/10/2023
 * @version 1.0
 */
@Data
public class OrganizationForm {

    private Long id;
    private String code;
    private String name;
    private Long orgLevel;
    private Long parentId;
    private Long orgType;
    private String description;
    private Date establishDate;
    private Date expiredDate;
    private String path;
    private String sortOrder;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
}
