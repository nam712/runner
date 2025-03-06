
package com.sCore.modules.permission.bo;


import lombok.Data;

import java.io.Serializable;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Data
public class RoleResourceActionID implements Serializable {
    private String roleCode;
    private String resourceCode;
    private String actionCode;
}
