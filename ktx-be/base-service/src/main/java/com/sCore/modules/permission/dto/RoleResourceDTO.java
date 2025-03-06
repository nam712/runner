package com.sCore.modules.permission.dto;

import com.sCore.modules.permission.bo.*;
import lombok.Data;

import java.util.List;

@Data
public class RoleResourceDTO {
    private List<Resource> resourceList;
    private List<ResourceAction> resourceActionList;
    private List<Action> actionList;
    private List<RoleResourceAction> roleResourceActionList;
}
