
package com.sCore.modules.permission.bo;


import lombok.Data;

/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Data
public class MenuForm {
    private Long id;
    private String code;
    private String name;
    private String parentCode;
    private String routerLink;
    private String icon;
    private Integer sortOrder;
}
