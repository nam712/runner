
package com.sCore.modules.settings.category.dao;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.core.utils.CommonUtil;
import com.sCore.modules.settings.category.bo.Category;
import com.sCore.modules.settings.category.bo.CategoryForm;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author score
 * @since 03/09/2021
 * @version 1.0
 */
@Transactional
@Repository
public interface CategoryDAO extends CRUDDao<Category, Long> {

    /**
     * List all Category
     */
    public List<Category> findAll();

    default String buildGetDataQuery(CategoryForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id           ";
        nativeSQL += "       ,code As code         ";
        nativeSQL += "       ,name As name         ";
        nativeSQL += "       ,description As description  ";
        nativeSQL += "       ,status As status       ";
        nativeSQL += "       ,sort_order As sortOrder    ";
        nativeSQL += "       ,created_by As createdBy    ";
        nativeSQL += "       ,created_date As createdDate  ";
        nativeSQL += "       ,modified_by As modifiedBy   ";
        nativeSQL += "       ,modified_date As modifiedDate ";
        nativeSQL += "       ,category_type_id As categoryTypeId ";
        nativeSQL += "       ,value As value        ";
        nativeSQL += "       ,extra_value As extraValue   ";
        nativeSQL += "       ,is_default As isDefault    ";
        nativeSQL += "       FROM category ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "name");
        CommonUtil.filter(form.getDescription(), strCondition, paramList, "description");
        CommonUtil.filter(form.getStatus(), strCondition, paramList, "status");
        CommonUtil.filter(form.getSortOrder(), strCondition, paramList, "sort_order");
        CommonUtil.filter(form.getCategoryTypeId(), strCondition, paramList, "category_type_id");
        CommonUtil.filter(form.getValue(), strCondition, paramList, "value");
        CommonUtil.filter(form.getExtraValue(), strCondition, paramList, "extra_value");
        CommonUtil.filter(form.getIsDefault(), strCondition, paramList, "is_default");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * 
     * @param dfData
     * @param form
     * @return
     */
    default List<Category> getAllDataQuery(DfData dfData, CategoryForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Category.class);
    }


    default DataTableResults<Category> getDatatables(
            DfData dfData,
            CategoryForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Category.class);
    }

    @Query("SELECT t FROM Category t where t.categoryTypeId = :categoryTypeId AND LOWER(t.code) = LOWER(:code) ")
    List<Category> findConflictedCode(@Param("categoryTypeId") Long categoryTypeId, @Param("code") String code);

    @Query("SELECT t FROM Category t where t.id <> :id  AND LOWER(t.code) = LOWER(:code)  AND t.categoryTypeId = :categoryTypeIdOld")
    List<Category> findConflictedCode(
            @Param("id") Long id,
            @Param("code") String code,
            @Param("categoryTypeIdOld") Long categoryTypeIdOld
            );
    
    @Query("SELECT t FROM Category t where t.id <> :id  AND LOWER(t.value) = LOWER(:value)  AND t.categoryTypeId = :categoryTypeIdOld")
    List<Category> findConflictedValue(
            @Param("id") Long id,
            @Param("value") Long value,
            @Param("categoryTypeIdOld") Long categoryTypeIdOld
            );
    
    List<Category> findByCategoryTypeId(Long categoryTypeId);
}
