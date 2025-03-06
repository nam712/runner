package com.sCore.modules.permission.form;

import lombok.Data;

import java.util.List;

@Data
public class UpdateRoleResourceActionForm {
    private String roleCode;
    private String resourceCode;
    private List<String> actionCodeList;
}
