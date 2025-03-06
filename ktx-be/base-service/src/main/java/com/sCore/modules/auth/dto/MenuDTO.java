package com.sCore.modules.auth.dto;

import com.sCore.modules.permission.bo.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuDTO {
    private String label;
    private String icon;
    private String routerLink;
    private String value;
    private String parentValue;
    private Integer sortOrder;

    public MenuDTO(Menu menu) {
        if (menu == null) {
            return;
        }
        this.label = menu.getName();
        this.icon = menu.getIcon();
        this.routerLink = menu.getRouterLink();
        this.value = menu.getCode();
        this.parentValue = menu.getParentCode();
        this.sortOrder = menu.getSortOrder();
    }
}
