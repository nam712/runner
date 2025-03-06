package com.sCore.modules.mngOrganization.dto;

import lombok.Data;

@Data
public class StatisticalByTypeDTO {
    private String code;
    private String name;
    private Long tong;
    private Long chuaHoc;
    private Long daHoc;
    private Long daDangKy;

}
