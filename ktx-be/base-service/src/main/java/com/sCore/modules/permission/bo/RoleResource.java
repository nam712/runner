
package com.sCore.modules.permission.bo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author sCore
 * @since 09/04/2024
 * @version 1.0
 */
@Data
@Entity
@Table(name = "p_role_resource")
public class RoleResource {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "resource_code")
    private String resourceCode;

}
