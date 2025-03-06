
package com.sCore.modules.mngOrganization.service;

import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.modules.mngOrganization.bo.Student;
import com.sCore.modules.mngOrganization.bo.StudentForm;
import com.sCore.modules.mngOrganization.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sCore
 * @since 06/11/2024
 * @version 1.0
 */
@Service
public class StudentService extends CRUDService<Student, StudentForm> {

    @Autowired
    private StudentDAO studentDAO;

        @Override
    public CRUDDao<Student, Long> getBaseDAO() {
        return studentDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Student> getDatatables(StudentForm form) {
        return studentDAO.getDatatables(dfData, form);
    }

    @Override
    protected void validateBeforeSave(Student entity, StudentForm form) throws ValidateException {
        if (dfData.duplicate(Student.class, "id", CommonUtil.NVL(form.getId()), "code", form.getCode())) {
            throw new ValidateException(Constants.RESPONSE_CODE.DUPLICATE_CODE, "Mã sinh viên đã tồn tại");
        }
    }

    public List<Student> findByCodeIn(List<String> lst) {
        return studentDAO.findByCodeIn(lst);
    }

}
