package com.sCore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSortOrderOrgDTO {
    private Long id;
    private String code;
    private String name;
    private String sortOrder;
    private Long orgLevel;
    private Long parentId;
    private String path;
}
