
package com.sCore.modules.permission.bo;


import lombok.Data;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Data
public class RoleResourceActionForm {

    private String roleCode;
    private String resourceCode;
    private String actionCode;
}
