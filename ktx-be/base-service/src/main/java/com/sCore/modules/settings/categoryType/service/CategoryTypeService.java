/*
 * Copyright (C) 2018 Viettel Telecom. All rights reserved. VIETTEL PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */

package com.sCore.modules.settings.categoryType.service;

import com.sCore.core.exception.PermissionException;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.core.utils.CommonUtil;
import com.sCore.exception.PermissionCheckerService;
import com.sCore.modules.settings.category.bo.Category;
import com.sCore.modules.settings.category.dao.CategoryDAO;
import com.sCore.modules.settings.categoryType.bo.CategoryType;
import com.sCore.modules.settings.categoryType.bo.CategoryTypeForm;
import com.sCore.modules.settings.categoryType.dao.CategoryTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author score
 * @since 01/09/2021
 * @version 1.0
 */
@Service
public class CategoryTypeService extends CRUDService<CategoryType, CategoryTypeForm> {

    @Autowired
    private CategoryTypeDAO categoryTypeDAO;

    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    PermissionCheckerService permissionCheckerService;

    @Override
    protected void checkPermission(String action) throws PermissionException {
        checkPermission("CATEGORY", action);
    }

    protected void checkPermission(String resource, String action) throws PermissionException {
        permissionCheckerService.check(resource, action);
    }
    @Override
    public CRUDDao<CategoryType, Long> getBaseDAO() {
        return categoryTypeDAO;
    }

    /**
     * getDatatables
     *
     * @param form
     *            form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<CategoryType> getDatatables(CategoryTypeForm form) {
        return categoryTypeDAO.getDatatables(dfData, form);
    }

    /**
     * Thuc hien validate truoc khi luu du lieu
     *
     * @param entity
     * @param form
     * @throws ValidateException
     */
    @Override
    public void validateBeforeSave(CategoryType entity, CategoryTypeForm form) throws ValidateException {
        List<CategoryType> lstCategoryType;
        if (CommonUtil.NVL(entity.getId()).equals(0L)) {
            lstCategoryType = categoryTypeDAO.findConflictedCode(form.getCode());
        } else {
            this.validateIsUse(entity);
            lstCategoryType = categoryTypeDAO.findConflictedCode(entity.getId(), form.getCode());
        }
        if (!CommonUtil.isNullOrEmpty(lstCategoryType)) {
            throw new ValidateException("setting.categoryType.duplicateCode", "Mã loại cấu hình đã tồn tại");
        }
    }

    public CategoryType findFirstByCode(String code) {
        return categoryTypeDAO.findFirstByCode(code);
    }

    public void validateIsUse(CategoryType entity) throws ValidateException {
        List<Category> lstCategory = categoryDAO.findByCategoryTypeId(entity.getId());
        if(!CommonUtil.isNullOrEmpty(lstCategory)) {
            throw new ValidateException("setting.categoryType.isUse", "Loại cấu hình đang được sửa dụng không được sửa, xóa");
        }

    }
}
