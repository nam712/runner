
package com.sCore.modules.mngOrganization.bo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

/**
 * @author sCore
 * @since 07/10/2023
 * @version 1.0
 */
@Data
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "org_type")
    private Long orgType;

    @Column(name = "description")
    private String description;

    @Column(name = "establish_date")
    private Date establishDate;

    @Column(name = "expired_date")
    private Date expiredDate;

    @Column(name = "path")
    private String path;

    @Column(name = "org_level")
    private Long orgLevel;

    @Column(name = "sort_order")
    private String sortOrder;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Transient
    private Long numChild;

    @Transient
    private boolean expanded;

    @Transient
    private List<Organization> childOrg;
}
