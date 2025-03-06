package com.sCore.modules.permission.bo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

public class UserRoleID implements Serializable {

    private Long userId;
    private Long roleId;
}