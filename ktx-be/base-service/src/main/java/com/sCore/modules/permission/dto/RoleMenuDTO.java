package com.sCore.modules.permission.dto;

import com.sCore.modules.permission.bo.Menu;
import lombok.Data;

import java.util.List;

@Data
public class RoleMenuDTO {
    private List<Menu> menuList;
    private List<String> menuCodeList;
}
