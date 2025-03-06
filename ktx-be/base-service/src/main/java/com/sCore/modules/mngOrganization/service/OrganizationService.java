
package com.sCore.modules.mngOrganization.service;

import com.sCore.core.exception.ValidateException;
import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.core.utils.CommonUtil;
import com.sCore.core.utils.Constants;
import com.sCore.dto.UpdateSortOrderOrgDTO;
import com.sCore.modules.mngOrganization.bo.OrgTreNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sCore.modules.mngOrganization.bo.Organization;
import com.sCore.modules.mngOrganization.bo.OrganizationForm;
import com.sCore.modules.mngOrganization.dao.OrganizationDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sCore
 * @since 07/10/2023
 * @version 1.0
 */
@Service
public class OrganizationService extends CRUDService<Organization, OrganizationForm> {

    @Autowired
    private OrganizationDAO organizationDAO;

        @Override
    public CRUDDao<Organization, Long> getBaseDAO() {
        return organizationDAO;
    }

    /**
     * getDatatables
     *
     * @param form form
     * @return DataTableResults
     */
    @Override
    public DataTableResults<Organization> getDatatables(OrganizationForm form) {
        return organizationDAO.getDatatables(dfData, form);
    }

    public List<OrgTreNode> getInitOrgTree() {
        Organization root = organizationDAO.findByOrgLevel(1L).stream().findFirst().orElse(null);
        if (root == null) {
            return null;
        }
        root.setExpanded(true);
        List<Organization> orgChildList = organizationDAO.getOrgTreeByParentId(dfData, root.getId());
        root.setChildOrg(orgChildList);
        root.setNumChild(orgChildList == null ? 0L : orgChildList.size());
        return Arrays.asList(new OrgTreNode(root));
    }
    public List<OrgTreNode> getChildOrg(Long parentId) {
        List<Organization> orgChildList = organizationDAO.getOrgTreeByParentId(dfData, parentId);
        if (orgChildList == null || orgChildList.isEmpty()) {
            return null;
        }
        return orgChildList.stream().map(OrgTreNode::new).collect(Collectors.toList());
    }

    @Override
    protected void customAfterSave(Organization entity, OrganizationForm form) throws ValidateException {
        String parentPath = "";
        String parentOrder = "";
        Long parentId = 0L;
        Long parentLevel = 0L;
        if (form.getParentId() != null && form.getParentId() > 0) {
            Organization parent = organizationDAO.findById(form.getParentId()).orElse(null);
            if (parent == null) {
                throw new ValidateException(Constants.RESPONSE_CODE.RECORD_DELETED, "Đơn vị cha không tồn tại");
            }
            entity.setPath(String.format("%s%s/", parent.getPath(), entity.getId()));
            entity.setOrgLevel(parent.getOrgLevel() + 1);
            parentPath = parent.getPath();
            parentOrder = parent.getSortOrder();
            parentId = form.getParentId();
            parentLevel = parent.getOrgLevel();
        } else {
            entity.setPath(String.format("/%s/", entity.getId()));
            entity.setOrgLevel(1L);
            parentPath = "/";
            parentOrder = "";
        }
        organizationDAO.save(entity);

        // update sort_order cung cap + cung don vi cha
        List<Organization> organizationList = new ArrayList<>();
        if (entity.getParentId() != null) {
            organizationList = organizationDAO.findByOrgLevelAndParentIdOrderByName(entity.getOrgLevel(), entity.getParentId());
        } else {
            organizationList = organizationDAO.findByOrgLevelOrderByName(entity.getOrgLevel());
        }
        List<Long> orgIds = organizationList.stream().map(Organization::getId).collect(Collectors.toList());

        List<UpdateSortOrderOrgDTO> list = organizationDAO.getAllNeedUpdateOrg(dfData, orgIds);

        // update sort_order don vi con
        this.updatePathAndOrder(list, parentId, parentOrder, parentPath, parentLevel);
        organizationDAO.updatePathAndOrder(dfData, list);
        System.out.println(" >>>>");
    }

    private void updatePathAndOrder(List<UpdateSortOrderOrgDTO> list
            , Long parentId, String parentOrder, String parentPath, Long parentLevel) {
        List<UpdateSortOrderOrgDTO> childList = list.stream().filter(x -> x.getParentId().equals(parentId)).collect(Collectors.toList());
        if (CommonUtil.isNullOrEmpty(childList)) {
            return;
        }
        int idx = 1;
        for (UpdateSortOrderOrgDTO org : childList) {
            org.setPath(String.format("%s%s/", parentPath, org.getId()));
            org.setOrgLevel(parentLevel + 1);
            org.setSortOrder(String.format("%s%s", parentOrder, String.format("%05d", idx++)));
            this.updatePathAndOrder(list, org.getId(), org.getSortOrder(), org.getPath(), org.getOrgLevel());
        }
    }
    @Override
    protected void validateBeforeSave(Organization entity, OrganizationForm form) throws ValidateException {
        form.setOrgLevel(entity.getOrgLevel());
        form.setPath(entity.getPath());
        form.setParentId(CommonUtil.NVL(form.getParentId()));
        if (dfData.duplicate(Organization.class, "id", CommonUtil.NVL(form.getId()), "code", form.getCode())) {
            throw new ValidateException(Constants.RESPONSE_CODE.DUPLICATE_CODE, "Mã đã tồn tại");
        }
    }

    public Organization getByCode(String orgCode) {
        return organizationDAO.findFirstByCode(orgCode);
    }


    @Override
    protected void customAfterDelete(Organization entity) throws ValidateException {
        // xoa con
        organizationDAO.deleteChild(String.format("%s", entity.getPath()) + "%");
    }
}
