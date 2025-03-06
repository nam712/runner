/*
 * Copyright (C) 2018 Viettel Telecom. All rights reserved. VIETTEL PROPRIETARY/CONFIDENTIAL. Use is
 * subject to license terms.
 */

package com.sCore.modules.settings.categoryType.dao;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.core.utils.CommonUtil;
import com.sCore.modules.settings.categoryType.bo.CategoryType;
import com.sCore.modules.settings.categoryType.bo.CategoryTypeForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


/**
 * @author score
 * @since 01/09/2021
 * @version 1.0
 */
@Transactional
@Repository
public interface CategoryTypeDAO extends CRUDDao<CategoryType, Long>
{
    /**
     * List all CategoryType
     */
    public List<CategoryType> findAll();

    default String buildGetDataQuery(CategoryTypeForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id           ";
        nativeSQL += "       ,code As code         ";
        nativeSQL += "       ,name As name         ";
        nativeSQL += "       ,status As status       ";
        nativeSQL += "       ,created_by As createdBy    ";
        nativeSQL += "       ,created_date As createdDate  ";
        nativeSQL += "       ,modified_by As modifiedBy   ";
        nativeSQL += "       ,modified_date As modifiedDate ";
        nativeSQL += "       FROM category_type ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "name");
        CommonUtil.filter(form.getStatus(), strCondition, paramList, "status");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData
     * @param form
     * @return
     */
    default List<CategoryType> getAllDataQuery(DfData dfData, CategoryTypeForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, CategoryType.class);
    }


    default DataTableResults<CategoryType> getDatatables(
            DfData dfData,
            CategoryTypeForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, CategoryType.class);
    }

	@Query("SELECT t FROM CategoryType t where LOWER(t.code) = LOWER(:code) ")
	List<CategoryType> findConflictedCode(@Param("code") String code);

	@Query("SELECT t FROM CategoryType t where t.id <> :id AND LOWER(t.code) = LOWER(:code) ")
	List<CategoryType> findConflictedCode(@Param("id") Long id, @Param("code") String code);

	
	/**
     * findFirstByCode
     * @param code
     * @return
     */
    CategoryType findFirstByCode(String code);
}
