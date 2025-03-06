
package com.sCore.modules.mngOrganization.service;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.modules.mngOrganization.bo.Classroom;
import com.sCore.modules.mngOrganization.bo.ClassroomForm;
import com.sCore.modules.mngOrganization.dao.ClassroomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sCore
 * @since 06/11/2024
 * @version 1.0
 */
@Service
public class ClassroomService extends CRUDService<Classroom, ClassroomForm> {

    @Autowired
    private ClassroomDAO classroomDAO;

        @Override
    public CRUDDao<Classroom, Long> getBaseDAO() {
        return classroomDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Classroom> getDatatables(ClassroomForm form) {
        return classroomDAO.getDatatables(dfData, form);
    }
}
