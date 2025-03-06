
package com.sCore.modules.ktx.dao;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.sCore.modules.ktx.dto.RoomStudentDTO;
import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.modules.ktx.bo.Room;
import com.sCore.modules.ktx.bo.RoomForm;


/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Transactional
@Repository
public interface RoomDAO extends CRUDDao<Room, Long>
{
    /**
     * List all Room
     */
    public List<Room> findAll();

    default String buildGetDataQuery(RoomForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "        r.id As id           ";
        nativeSQL += "       ,r.code As code         ";
        nativeSQL += "       ,r.name As name         ";
        nativeSQL += "       ,r.room_type_code As roomTypeCode ";
        nativeSQL += "       ,r.amount As amount       ";
        nativeSQL += "       ,r.created_date As createdDate  ";
        nativeSQL += "       ,r.created_by As createdBy    ";
        nativeSQL += "       ,r.modified_date As modifiedDate ";
        nativeSQL += "       ,r.modified_by As modifiedBy   ";
        nativeSQL += "       ,rt.name As roomTypeName   ";
        nativeSQL += "       ,rs.in_use As inUse   ";
        nativeSQL += "       FROM room r ";
        nativeSQL += "       INNER JOIN room_type rt ON rt.code = r.room_type_code ";
        nativeSQL += "       INNER JOIN v_room_summary rs ON rs.code = r.code ";
        String orderBy = " ORDER BY r.id DESC";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
        CommonUtil.filter(form.getId(), strCondition, paramList, "r.id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "r.code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "r.name");
        CommonUtil.filter(form.getRoomTypeCode(), strCondition, paramList, "r.room_type_code");
        CommonUtil.filter(form.getAmount(), strCondition, paramList, "r.amount");
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData DfData
     * @param form RoomForm
     * @return List
     */
    default List<Room> getAllDataQuery(DfData dfData, RoomForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Room.class);
    }

    /**
     * get data by datatable
     *
     * @param dfData DfData
     * @param form RoomForm
     * @return DataTableResults
     */
    default DataTableResults<Room> getDatatables(
            DfData dfData,
            RoomForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Room.class);
    }

    public List<Room> findByCodeIn(List<String> codeList);
    public Room findFirstByCode(String code);

    public default List<RoomStudentDTO> getRoomStudent(DfData dfData, String roomCode) {
        String query = "     " +
                " select     " +
                "  c.room_code as roomCode,    " +
                "  s.code as studentCode,    " +
                "  s.fullname as studentFullname,    " +
                "  s.date_of_birth as dateOfBirth,    " +
                "  s.address as address,    " +
                "  s.gender as gender,    " +
                "  s.phone_number as phoneNumber,    " +
                "  s.classroom_code as classroomCode,    " +
                "  c.code as contractCode    " +
                " from student s    " +
                " inner join contract c on s.code = c.student_code    " +
                " where 1=1    " +
                " and c.status = 'ACTIVE'    " +
                " and c.room_code = ? ";
        List<Object> paramList = new ArrayList<>();
        paramList.add(roomCode);
        return dfData.list(query, paramList, RoomStudentDTO.class);
    }
}
