
package com.sCore.modules.mngOrganization.bo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author sCore
 * @since 06/11/2024
 * @version 1.0
 */
@Data
@Entity
@Table(name = "classroom")
public class Classroom {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "modified_by")
    private String modifiedBy;

}
