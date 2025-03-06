package com.sCore.modules.permission.bo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "p_user_role")
@IdClass(UserRoleID.class)
public class UserRole {
    @Id
    @Column(name = "user_id", insertable = false, updatable = false)
    private Long userId;

    @Id
    @Column(name = "role_id")
    private Long roleId;

}
