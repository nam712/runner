
package com.sCore.modules.settings.category.service;

import com.sCore.core.exception.PermissionException;
import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.constant.SearchOperation;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.form.SearchCriteria;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.core.utils.CommonUtil;
import com.sCore.exception.PermissionCheckerService;
import com.sCore.modules.settings.category.bo.Category;
import com.sCore.modules.settings.category.bo.CategoryForm;
import com.sCore.modules.settings.category.dao.CategoryDAO;
import com.sCore.modules.settings.categoryType.bo.CategoryType;
import com.sCore.modules.settings.categoryType.dao.CategoryTypeDAO;
import com.sCore.modules.settings.categoryType.service.CategoryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author score
 * @since 03/09/2021
 * @version 1.0
 */
@Service
public class CategoryService extends CRUDService<Category, CategoryForm> {

    @Autowired
    private CategoryDAO categoryDAO;
    
    @Autowired
    private CategoryTypeDAO categoryTypeDAO;

    @Autowired
    private CategoryTypeService categoryTypeService;
    @Autowired
    PermissionCheckerService permissionCheckerService;

    @Override
    protected void checkPermission(String action) throws PermissionException {
        checkPermission("CATEGORY", action);
    }

    protected void checkPermission(String resource, String action) throws PermissionException {
        permissionCheckerService.check(resource, action);
    }

    @Override
    public CRUDDao<Category, Long> getBaseDAO() {
        return categoryDAO;
    }

    /**
     * getDatatables
     *
     * @param form
     *            form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Category> getDatatables(CategoryForm form) {
        return categoryDAO.getDatatables(dfData, form);
    }

    /**
     * Thuc hien validate truoc khi luu du lieu
     *
     * @param entity
     * @param form
     * @throws ValidateException
     */
    @Override
    public void validateBeforeSave(Category entity, CategoryForm form) throws ValidateException {
        List<Category> lstSysCat;
        // validate trùng giá trị
        Long id = entity.getId() != null ? entity.getId(): 0L;
        if (!CommonUtil.isNullOrEmpty(categoryDAO.findConflictedValue(id, form.getValue(), form.getCategoryTypeId()))) {
            throw new ValidateException("app.category.duplicateValue", "Mã cấu hình đã tồn tại");
        }
        if (CommonUtil.NVL(entity.getId()).equals(0L)) {
            lstSysCat = categoryDAO.findConflictedCode(form.getCategoryTypeId(), form.getCode());
        } else {
//            this.validateIsUseCategory(entity); // validate đang sử dụng k đk sửa
            lstSysCat = categoryDAO.findConflictedCode(entity.getId(), form.getCode(), form.getCategoryTypeId());
        }
        if (!CommonUtil.isNullOrEmpty(lstSysCat)) {
            throw new ValidateException("app.category.duplicateCode", "Mã cấu hình đã tồn tại");
        }
        
    }
    
    @Override
    public void validateBeforeDelete(Category entity) throws ValidateException {
//        this.validateIsUseCategory(entity);
    }
    
//    public void validateIsUseCategory(Category entity) throws ValidateException {
//     // lấy loại cấu hình
//        CategoryType categoryType = categoryTypeDAO.getOne(entity.getCategoryTypeId());
//        if(categoryType != null) {
//            switch (categoryType.getCode()) {
//                case Constants.CATEGORY_TYPE.NGUON_VON:
//                    // tìm trong tờ trình
//                    List<Statement> lst = statementDAO.findBySrcFunds(entity.getValue());
//                    // gói thầu
//                    List<PackageBid> lstPackageBid = packageBidDAO.findBySrcFunds(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lst) || !CommonUtil.isNullOrEmpty(lstPackageBid)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.PHUONG_THUC_LCNT:
//                    // gói thầu
//                    List<PackageBid> lstPackageBidBymethod = packageBidDAO.findByMethod(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstPackageBidBymethod)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.LOAI_HANG_HOA:
//                    // tìm xem cấu hình đã đk sửa dụng trong hàng hóa dịch vụ
//                    List<ItemService> lstItemService = itemServiceDAO.findByTypeAndStatus(entity.getValue(), Constants.CATEGORY_STATUS.HIEU_LUC);
//                    if(!CommonUtil.isNullOrEmpty(lstItemService)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.LOAI_HOP_DONG:
//                    List<PackageBid> lstPackageBidByType = packageBidDAO.findByCtrType(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstPackageBidByType)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.CHUC_VU:
//                    List<Expert> lstExpert = expertDAO.findByJobTitle(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstExpert)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.STATEMENT_STATUS:
//                    List<Statement> lstStatement = statementDAO.findByStatus(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstStatement)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.DON_VI_TINH:
//                    List<ItemService> lstItemServiceDVT = itemServiceDAO.findByUnitAndStatus(entity.getValue(), Constants.CATEGORY_STATUS.HIEU_LUC);
//                    if(!CommonUtil.isNullOrEmpty(lstItemServiceDVT)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.KPI:
//                    List<FormalityKpi> lstFormalityKpi = formalityKpiDAO.findByKpiId(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstFormalityKpi)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.CONTACT_DELIVERY_TYPE: // Loại biên bản bàn giao/ nghiệm thu hợp đồng
//                    List<DeliveryRecords> lstDeliveryRecords = deliveryRecordsDAO.findByType(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstDeliveryRecords)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.PROFILE_BID_STATUS: // Trạng thái hồ sơ mời thầu
//                    List<ProfileBid> lstProfileBid = profileBidDAO.findByStatus(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstProfileBid)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.STATEMENT_EXPERT_STATUS: // Trạng thái tờ trình thành lập tổ chuyên gia
//                    List<StatementExpert> lstStatementExpert = statementExpertDAO.findByStatus(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstStatementExpert)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.EVALUATE_PROFILE_BID_STATUS: // Trạng thái báo cáo đánh giá hồ sơ dự thầu
//                    List<EvaluateProfileBid> lstEvaluateProfileBid = evaluateProfileBidDAO.findByStatus(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstEvaluateProfileBid)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.PACKAGE_PIB_STATUS: // Trạng thái gói thầu
//                    List<PackageBid> lstPackageBidByStatus = packageBidDAO.findByStatus(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstPackageBidByStatus)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.CONTACT_PAYMENT_TYPE: // Loại biên bản thanh toán hoặc tạm ứng
//                    List<ContractPayment> lstContractPayment = contractPaymentDAO.findByType(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstContractPayment)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.CONTACT_GUARANTEE_TYPE: // Loại bảo lãnh hợp đồng
//                    List<ContractGuarantee> lstContractGuarantee = contractGuaranteeDAO.findByType(entity.getValue());
//                    if(!CommonUtil.isNullOrEmpty(lstContractGuarantee)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                case Constants.CATEGORY_TYPE.CONTACT_GUARANTEE_NAME: // Tên bảo lãnh hợp đồng
//                    List<ContractGuarantee> lstContractGuaranteeName = contractGuaranteeDAO.findByName(entity.getValue());
//                    if( !CommonUtil.isNullOrEmpty(lstContractGuaranteeName)) {
//                        throw new ValidateException("app.category.isUse", "Cấu hình đang được sử dụng không được sửa, xóa");
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }
//    }

    public List<Category> findByGroupCode(String groupCode) {
        CategoryType categoryType = categoryTypeService.findFirstByCode(groupCode);
        Long categoryTypeId = categoryType != null ? categoryType.getId() : -1L;
        return categoryDAO.findByCategoryTypeId(categoryTypeId);
    }
}
