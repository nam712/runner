
package com.sCore.modules.ktx.dao;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.ktx.bo.WaterElectric;
import com.sCore.modules.ktx.bo.WaterElectricForm;


/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface WaterElectricDAO extends CRUDDao<WaterElectric, Long>
{
    /**
     * List all WaterElectric
     */
    public List<WaterElectric> findAll();

    default String buildGetDataQuery(WaterElectricForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        we.id As id           ";
        nativeSQL += "       ,we.month As month        ";
        nativeSQL += "       ,we.year As year         ";
        nativeSQL += "       ,we.room_code As roomCode     ";
        nativeSQL += "       ,we.type As type         ";
        nativeSQL += "       ,we.old_numeral As oldNumeral   ";
        nativeSQL += "       ,we.new_numeral As newNumeral   ";
        nativeSQL += "       ,we.created_date As createdDate  ";
        nativeSQL += "       ,we.created_by As createdBy    ";
        nativeSQL += "       ,we.modified_date As modifiedDate ";
        nativeSQL += "       ,we.modified_by As modifiedBy   ";
        nativeSQL += "       ,r.name As roomName   ";
        nativeSQL += "       FROM water_electric we ";
        nativeSQL += "       INNER JOIN room r ON r.code = we.room_code ";
        String orderBy = " ORDER BY we.year DESC, we.month DESC, we.room_code, we.type ";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "we.id");
        CommonUtil.filter(form.getMonth(), strCondition, paramList, "we.month");
        CommonUtil.filter(form.getYear(), strCondition, paramList, "we.year");
        CommonUtil.filter(form.getRoomCode(), strCondition, paramList, "we.room_code");
        CommonUtil.filter(form.getType(), strCondition, paramList, "we.type");
        CommonUtil.filter(form.getOldNumeral(), strCondition, paramList, "we.old_numeral");
        CommonUtil.filter(form.getNewNumeral(), strCondition, paramList, "we.new_numeral");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form WaterElectricForm
     * @return List
     */
    default List<WaterElectric> getAllDataQuery(DfData dfData, WaterElectricForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, WaterElectric.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form WaterElectricForm
     * @return DataTableResults
     */
    default DataTableResults<WaterElectric> getDatatables(
            DfData dfData,
            WaterElectricForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, WaterElectric.class);
    }

    public List<WaterElectric> findByRoomCodeIn(List<String> code);
    public List<WaterElectric> findByRoomCodeInAndMonthAndYear(List<String> code, Integer month, Integer year);
    public List<WaterElectric> findByRoomCodeAndMonthAndYearAndTypeAndIdNot(String code, Integer month, Integer year, String type, Long id);

    public  default WaterElectric getNearestWaterElectric(DfData dfData, WaterElectricForm form) {
        String nativeSQL = "    " +
                "  SELECT    " +
                "    id as id,    " +
                "    month as month,    " +
                "    year as year,    " +
                "    room_code as roomCode,    " +
                "    type as type,    " +
                "    old_numeral as oldNumeral,    " +
                "    new_numeral as newNumeral     " +
                "  FROM    " +
                "    water_electric     " +
                "  WHERE    " +
                "    room_code = :roomCode     " +
                "    AND type = :type     " +
                "    AND (    " +
                "      YEAR < :year     " +
                "    OR ( YEAR = :year AND MONTH < :month ))     " +
                "  ORDER BY    " +
                "    YEAR DESC,    " +
                "  MONTH DESC     " +
                "    LIMIT 1 ";
        Map<String, Object> params = new HashMap<>();
        params.put("roomCode", form.getRoomCode());
        params.put("type", form.getType());
        params.put("year", form.getYear());
        params.put("month", form.getMonth());
        List<WaterElectric> waterElectrics = dfData.list(nativeSQL, params, WaterElectric.class);
        return CommonUtil.isNullOrEmpty(waterElectrics) ? null : waterElectrics.get(0);
    }
}
