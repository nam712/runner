
package com.sCore.modules.permission.bo;


import javax.persistence.*;

import lombok.Data;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Data
@Entity
@Table(name = "p_role_resource_action")
@IdClass(RoleResourceActionID.class)
public class RoleResourceAction {

    @Id
    @Column(name = "role_code")
    private String roleCode;

    @Id
    @Column(name = "resource_code")
    private String resourceCode;

    @Id
    @Column(name = "action_code")
    private String actionCode;

}
