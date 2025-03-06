
package com.sCore.modules.settings.category.bo;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author score
 * @since 03/09/2021
 * @version 1.0
 */
@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Long status;

    @Column(name = "sort_order")
    private Integer sortOrder;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "category_type_id")
    private Long categoryTypeId;

    @Column(name = "value")
    private Long value;

    @Column(name = "extra_value")
    private String extraValue;

    @Column(name = "is_default")
    private Long isDefault;

}
