/*
 * Copyright (C) 2018 Viettel Telecom. All rights reserved. VIETTEL PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */

package com.sCore.modules.settings.categoryType.bo;

import lombok.Data;

import java.util.Date;

/**
 * @author score
 * @since 01/09/2021
 * @version 1.0
 */
@Data
public class CategoryTypeForm {

    private Long id;
    private String code;
    private String name;
    private Long status;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

}
