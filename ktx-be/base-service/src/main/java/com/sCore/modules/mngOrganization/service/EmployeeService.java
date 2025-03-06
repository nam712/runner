
package com.sCore.modules.mngOrganization.service;

import com.sCore.core.config.I18n;
import com.sCore.core.exception.PermissionException;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.core.utils.*;
import com.sCore.exception.PermissionCheckerService;
import com.sCore.modules.mngOrganization.bo.Organization;
import com.sCore.modules.mngOrganization.dao.OrganizationDAO;
import com.sCore.modules.mngOrganization.dto.StatisticalByTypeDTO;
import com.sCore.modules.settings.category.bo.Category;
import com.sCore.modules.settings.category.service.CategoryService;
import com.sCore.utils.CommonUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


import com.sCore.modules.mngOrganization.bo.Employee;
import com.sCore.modules.mngOrganization.bo.EmployeeForm;
import com.sCore.modules.mngOrganization.dao.EmployeeDAO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sCore
 * @since 07/10/2023
 * @version 1.0
 */
@Service
public class EmployeeService extends CRUDService<Employee, EmployeeForm> {

    @Autowired
    private EmployeeDAO employeeDAO;


    @Autowired
    private OrganizationDAO organizationDAO;

    @Autowired
    CategoryService categoryService;
    @Autowired
    CommonUtilsService commonUtilsService;

    @Autowired
    PermissionCheckerService permissionCheckerService;

    @Override
    protected void checkPermission(String action) throws PermissionException {
        checkPermission("EMPLOYEE", action);
    }

    protected void checkPermission(String resource, String action) throws PermissionException {
        permissionCheckerService.check(resource, action);
    }

    @Override
    public CRUDDao<Employee, Long> getBaseDAO() {
        return employeeDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Employee> getDatatables(EmployeeForm form) throws PermissionException {
        checkPermission("VIEW");
        if (form.getOrganizationWork() != null) {
            List<Organization> organizationList = organizationDAO.findByPathContaining(String.format("/%s/", form.getOrganizationWork()));
            List<Long> orgIds = CommonUtil.isNullOrEmpty(organizationList)
                    ? Collections.singletonList(-1L)
                    : organizationList.stream().map(Organization::getId).collect(Collectors.toList());
            form.setOrgIds(orgIds);
        }

        DataTableResults<Employee> dataTableResults = employeeDAO.getDatatables(dfData, form);
        if (CommonUtil.isNullOrEmpty(dataTableResults.getData())) {
            return dataTableResults;
        }

        // Lấy tên đối tượng QPAN
        List<Category> lstQPAN = categoryService.findByGroupCode("DOI_TUONG_QPAN");

        // Lay ten don vi trong hoc vien
        List<Employee> employeeList = dataTableResults.getData();
        List<Long> orgIds = employeeList.stream()
                .map(Employee::getOrganizationWork)
                .distinct().collect(Collectors.toList());
        List<Organization> organizations = new ArrayList<>();
        if (!CommonUtil.isNullOrEmpty(orgIds)) {
            organizations = organizationDAO.findByIdIn(orgIds);
        }
        for (Employee emp : employeeList) {
            Organization org = organizations.stream()
                    .filter(x -> x.getId().equals(emp.getOrganizationWork()))
                    .findFirst().orElse(null);
            emp.setOrganizationName(org != null ? org.getName() : "");
        }
        dataTableResults.setData(employeeList);


        return dataTableResults;
    }

    public String getTemplateImport() throws Exception {
        String importTemplateName = "BM_import_ho_so.xlsx";
        String pathTemplate = "template/import/employee/" + importTemplateName;
        DynamicExport dynamicExport = new DynamicExport(pathTemplate, 2, true);
        // set các danh mục
        dynamicExport.setActiveSheet(1);
        int row = 1;

        // Đơn vị

        List<Organization> lstOrganization = organizationDAO.findAll(Sort
                .by(Sort.Direction.ASC, "OrgLevel")
                .and(Sort.by(Sort.Direction.ASC, "Name"))
        );
        if (!CommonUtil.isNullOrEmpty(lstOrganization)) {
            for (Organization org: lstOrganization) {
                dynamicExport.setText(org.getName(), 4, row++);
            }
        }

        // Dan toc
        row = 1;
        List<Category> lstEthnic = categoryService.findByGroupCode("DT");
        if (!CommonUtil.isNullOrEmpty(lstEthnic)) {
            for (Category category: lstEthnic) {
                dynamicExport.setText(category.getName(), 6, row++);
            }
        }

        // Cap bac
        row = 1;
        List<Category> lstRankLevel = categoryService.findByGroupCode("CAP_BAC");
        if (!CommonUtil.isNullOrEmpty(lstRankLevel)) {
            for (Category category: lstRankLevel) {
                dynamicExport.setText(category.getName(), 8, row++);
            }
        }

        // Doi tuong QPAN
        row = 1;
        List<Category> lstQPAN = categoryService.findByGroupCode("DOI_TUONG_QPAN");
        if (!CommonUtil.isNullOrEmpty(lstQPAN)) {
            for (Category category: lstQPAN) {
                dynamicExport.setText(category.getName(), 10, row++);
            }
        }


        dynamicExport.setActiveSheet(0);
        String fileName = commonUtilsService.getFilePathExport(importTemplateName);
        dynamicExport.exportFile(fileName);
        return fileName;
    }

    public Response importEmployee(HttpServletRequest request, MultipartFile file, Authentication authentication) throws Exception, PermissionException {
        checkPermission("IMPORT");
        String fileConfigName = "BM_import_ho_so.xml";
        ImportExcel importExcel = new ImportExcel("template/import/employee/" + fileConfigName, request);
        List<Object[]> dataList = new ArrayList<>();
        Response resultValidate = commonUtilsService.validateFileImport(request, importExcel, file, dataList);
        if (resultValidate != null) {
            return resultValidate;
        }
        // Danh sách đối tượng hợp lệ lưu vào database
        List<Employee> employeeList = new ArrayList<>();

        // Validate trùng employee code
        List<String> listEmployeeCode = new ArrayList<>();
        for (Object[] obj : dataList) {
            listEmployeeCode.add(((String) obj[1]).toUpperCase());
        }
        List<Employee> employeeDuplicate = employeeDAO.findByCodeIn(listEmployeeCode);
        List<String> codeDuplicate = !CommonUtil.isNullOrEmpty(employeeDuplicate)
                ? employeeDuplicate.stream().map(Employee::getCode).collect(Collectors.toList())
                : new ArrayList<>();
//        if (!CommonUtil.isNullOrEmpty(employeeDuplicate)) {
//            List<String> codeDuplicate = employeeDuplicate.stream().map(Employee::getCode).collect(Collectors.toList());
//            int row = -1;
//            for (Object[] obj : dataList) {
//                row++;
//                String code = (String) obj[1];
//                if (codeDuplicate.contains(code)) {
//                    importExcel.addError(row, 1, I18n.getMessage("employee.validate.duplicateCode", code), code);
//                }
//            }
//
//            if (importExcel.hasError()) {
//                return commonUtilsService.responseErrorImportFile(importExcel, file, authentication);
//            }
//        }
        // Map dân tôc
        List<Category> lstEthnic = categoryService.findByGroupCode("DT");
        Map<String, Category> mapEthnic = new HashMap<>();
        for (Category ethnic : lstEthnic) {
            mapEthnic.put(ethnic.getName(), ethnic);
        }

        // Map cấp bậc
        List<Category> lstRankLevel = categoryService.findByGroupCode("CAP_BAC");
        Map<String, Category> mapRankLevel = new HashMap<>();
        for (Category rank : lstRankLevel) {
            mapEthnic.put(rank.getName(), rank);
        }

        // Map doi tuong QPAN
        List<Category> lstQPAN = categoryService.findByGroupCode("DOI_TUONG_QPAN");
        Map<String, Category> mapQPAN = new HashMap<>();
        for (Category qpan : lstQPAN) {
            mapQPAN.put(qpan.getName(), qpan);
        }

        // Map dơn vi
        Map<String, Organization> mapOrg = new HashMap<>();

        int row = -1;
        for (Object[] obj : dataList) {
            row++;
            Employee employee = new Employee();

            // Số hiệu
            employee.setCode((String) obj[1]);
            if (codeDuplicate.contains(employee.getCode())) {
                importExcel.addError(row, 1, I18n.getMessage("employee.validate.duplicateCode", employee.getCode()), employee.getCode());
            }

            // Họ và tên
            String fullName = (String) obj[2];
            employee.setFullname(fullName);
            employee.setFirstName(fullName.substring(0, fullName.lastIndexOf(" ")));
            employee.setLastName(fullName.substring(fullName.lastIndexOf(" ") + 1, fullName.length()));

            // Ngày sinh
            Date dobStr = (Date) obj[3];
            employee.setDateOfBirth(dobStr);

            // Giới tính
            String genderStr = (String) obj[4];
            employee.setGender(genderStr.equals("Nam") ? 1 : 0);

            // Quê quán
            employee.setAddress((String) obj[5]);

            // Diện đối tượng
            String typeStr = (String) obj[6];
            employee.setType(typeStr.equals("Cán bộ") ? "OFFICERS" : "STUDENT");

            // Đơn vị trong HV
            String orgStr = (String) obj[7];
            // Đơn vị ngoài HV
            String orgOutsideStr = (String) obj[8];
            if (mapOrg.containsKey(orgStr)) {
                employee.setOrganizationWork(mapOrg.get(orgStr).getId());
            } else {
                Organization org = organizationDAO.findFirstByName(orgStr);
                if (org == null) {
                    importExcel.addError(row, 1, I18n.getMessage("employee.validate.invalidOrg"), orgStr);
                } else {
                    mapOrg.put(orgStr, org);
                    employee.setOrganizationWork(org.getId());
                }
            }

            // Dân tộc
            String ethnicStr = (String) obj[9];
            if (!mapEthnic.containsKey(ethnicStr)) {
                importExcel.addError(row, 1, I18n.getMessage("employee.validate.invalidEthnic"), ethnicStr);
            } else {
                employee.setEthnic(mapEthnic.get(ethnicStr).getId());
            }

            // Ngày vào Đảng
            Date partyDate = (Date) obj[11];
            if (partyDate != null) {
                employee.setPartyDate(partyDate);
                employee.setIsPartyMember(1);
            } else {
                employee.setIsPartyMember(0);
            }

            // SĐT
            employee.setPhoneNumber((String) obj[12]);

            employee.setCreatedBy(UserUtil.getUserLoginName(request));
            employee.setCreatedDate(new Date());
            employeeList.add(employee);
        }
        if (importExcel.hasError()) {
            return commonUtilsService.responseErrorImportFile(importExcel, file);
        }
        // save data to database
        employeeDAO.saveAll(employeeList);

        return Response.success(Constants.RESPONSE_CODE.SUCCESS);
    }

    @Override
    protected void validateBeforeSave(Employee entity, EmployeeForm form) throws ValidateException {
        Long id = CommonUtil.NVL(form.getId());
        List<Employee> employeeList = employeeDAO.findConflictedCode(form.getCode(), id);
        if (!CommonUtil.isNullOrEmpty(employeeList)) {
            throw new ValidateException(Constants.RESPONSE_CODE.DUPLICATE_CODE, "Trùng mã");
        }
    }

    @Override
    protected void customBeforeSave(Employee entity, EmployeeForm form) throws ValidateException {
        String fullName = form.getFullname();
        entity.setFirstName(fullName.substring(0, fullName.lastIndexOf(" ")));
        entity.setLastName(fullName.substring(fullName.lastIndexOf(" ") + 1, fullName.length()));
    }

    public Employee findByCode(String code) {
        return employeeDAO.findFirstByCode(code);
    }

}
