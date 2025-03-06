
package com.sCore.modules.ktx.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.ktx.bo.RoomType;
import com.sCore.modules.ktx.bo.RoomTypeForm;


/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface RoomTypeDAO extends CRUDDao<RoomType, Long>
{
    /**
     * List all RoomType
     */
    public List<RoomType> findAll();

    default String buildGetDataQuery(RoomTypeForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        id As id           ";
        nativeSQL += "       ,code As code         ";
        nativeSQL += "       ,name As name         ";
        nativeSQL += "       ,building As building     ";
        nativeSQL += "       ,created_date As createdDate  ";
        nativeSQL += "       ,created_by As createdBy    ";
        nativeSQL += "       ,modified_date As modifiedDate ";
        nativeSQL += "       ,modified_by As modifiedBy   ";
        nativeSQL += "       FROM room_type ";
        String orderBy = " ORDER BY id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "name");
        CommonUtil.filter(form.getBuilding(), strCondition, paramList, "building");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form RoomTypeForm
     * @return List
     */
    default List<RoomType> getAllDataQuery(DfData dfData, RoomTypeForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, RoomType.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form RoomTypeForm
     * @return DataTableResults
     */
    default DataTableResults<RoomType> getDatatables(
            DfData dfData,
            RoomTypeForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, RoomType.class);
    }
}
