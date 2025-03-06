package com.sCore.modules.auth.form;

import lombok.Data;

@Data
public class ChangePasswordForm {
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;
}
