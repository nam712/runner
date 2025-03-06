package com.sCore.exception;


import com.sCore.core.exception.PermissionException;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.UserUtil;
import com.sCore.modules.permission.dto.UserPermissionDTO;
import com.sCore.modules.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionCheckerService {
    @Autowired
    UserService userService;

    public void check(String resource, String action) throws PermissionException {
        String permission = String.format("%s__%s", resource, action);

        List<UserPermissionDTO> userPermissionDTOS = userService.findUserPermission();
        if (CommonUtil.isNullOrEmpty(userPermissionDTOS)) {
            throw new PermissionException();
        }

        List<String> permissionList = userPermissionDTOS.stream().map(UserPermissionDTO::getPermission).collect(Collectors.toList());
        if (!permissionList.contains(permission)) {
            throw new PermissionException();
        }
    }
}
