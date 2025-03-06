
package com.sCore.modules.permission.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.permission.bo.Resource;
import com.sCore.modules.permission.bo.ResourceForm;


/**
 * @author sCore
 * @since 08/04/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface ResourceDAO extends CRUDDao<Resource, Long>
{
    /**
     * List all Resource
     */
    public List<Resource> findAll();

    default String buildGetDataQuery(ResourceForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        code As code         ";
        nativeSQL += "       ,name As name         ";
        nativeSQL += "       ,created_date As createdDate  ";
        nativeSQL += "       ,created_by As createdBy    ";
        nativeSQL += "       ,modified_date As modifiedDate ";
        nativeSQL += "       ,modified_by As modifiedBy   ";
        nativeSQL += "       FROM p_resource ";
        String orderBy = " ORDER BY code DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "name");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form ResourceForm
     * @return List
     */
    default List<Resource> getAllDataQuery(DfData dfData, ResourceForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Resource.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form ResourceForm
     * @return DataTableResults
     */
    default DataTableResults<Resource> getDatatables(
            DfData dfData,
            ResourceForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Resource.class);
    }

    List<Resource> findByCodeIn(List<String> codeList);
}
