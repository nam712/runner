
package com.sCore.modules.ktx.service;

import com.sCore.modules.ktx.dto.RoomStudentDTO;
import com.sCore.modules.mngOrganization.bo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.ktx.bo.Room;
import com.sCore.modules.ktx.bo.RoomForm;
import com.sCore.modules.ktx.dao.RoomDAO;

import java.util.List;

/**
 * @author sCore
 * @since 11/11/2024
 * @version 1.0
 */
@Service
public class RoomService extends CRUDService<Room, RoomForm> {

    @Autowired
    private RoomDAO roomDAO;

        @Override
    public CRUDDao<Room, Long> getBaseDAO() {
        return roomDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Room> getDatatables(RoomForm form) {
        return roomDAO.getDatatables(dfData, form);
    }


    public List<RoomStudentDTO> getRoomStudent(String roomCode) {
        return roomDAO.getRoomStudent(dfData, roomCode);
    }
}
