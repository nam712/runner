package com.sCore.modules.auth.dto;

import com.sCore.modules.mngOrganization.bo.Employee;
import com.sCore.modules.permission.dto.UserPermissionDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private Employee user;
    private List<MenuDTO> menuList;
    private List<UserPermissionDTO> userPermissionList;
}
