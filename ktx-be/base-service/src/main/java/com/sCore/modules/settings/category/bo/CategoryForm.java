
package com.sCore.modules.settings.category.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author score
 * @since 03/09/2021
 * @version 1.0
 */
@Data
public class CategoryForm {

    private Long id;
    private String code;
    private String name;
    private String description;
    private Long status;
    private Integer sortOrder;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private Long categoryTypeId;
    private Long value;
    private String extraValue;
    private Long isDefault;
}
