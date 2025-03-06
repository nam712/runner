package com.sCore.modules.permission.form;

import lombok.Data;

import java.util.List;

@Data
public class UpdateRoleMenuForm {
    private Long roleId;
    private List<String> menuCodeList;
}
