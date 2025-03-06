
package com.sCore.modules.mngOrganization.dao;

import java.util.*;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.sCore.core.resful.dao.CRUDDao;
import com.sCore.core.resful.domain.DataTableResults;
import com.sCore.core.resful.utils.DfData;
import com.sCore.dto.UpdateSortOrderOrgDTO;
import com.sCore.modules.settings.category.bo.Category;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sCore.core.utils.CommonUtil;
import com.sCore.modules.mngOrganization.bo.Organization;
import com.sCore.modules.mngOrganization.bo.OrganizationForm;


/**
 * @author sCore
 * @since 07/10/2023
 * @version 1.0
 */
@Transactional
@Repository
public interface OrganizationDAO extends CRUDDao<Organization, Long>
{
    /**
     * List all Organization
     */
    public List<Organization> findAll();

    default String buildGetDataQuery(OrganizationForm form, List<Object> paramList) {
        String nativeSQL = "SELECT ";
        nativeSQL += "       id As id           ";
        nativeSQL += "       ,code As code         ";
        nativeSQL += "       ,name As name         ";
        nativeSQL += "       ,org_level As orgLevel         ";
        nativeSQL += "       ,parent_id As parentId     ";
        nativeSQL += "       ,org_type As orgType      ";
        nativeSQL += "       ,description As description  ";
        nativeSQL += "       ,establish_date As establishDate ";
        nativeSQL += "       ,expired_date As expiredDate  ";
        nativeSQL += "       ,path As path         ";
        nativeSQL += "       ,sort_order As sortOrder         ";
        nativeSQL += "       ,created_by As createdBy    ";
        nativeSQL += "       ,created_date As createdDate  ";
        nativeSQL += "       ,modified_by As modifiedBy   ";
        nativeSQL += "       ,modified_date As modifiedDate ";
        nativeSQL += "       FROM organization ";
        String orderBy = " ORDER BY org_level, name ";
        StringBuilder strCondition = new StringBuilder(" WHERE 1 = 1 ");
//        CommonUtil.filter(form.getId(), strCondition, paramList, "id");
        CommonUtil.filter(form.getCode(), strCondition, paramList, "code");
        CommonUtil.filter(form.getName(), strCondition, paramList, "name");
        CommonUtil.filter(form.getOrgLevel(), strCondition, paramList, "org_level");
        CommonUtil.filter(form.getParentId(), strCondition, paramList, "parent_id");
        CommonUtil.filter(form.getOrgType(), strCondition, paramList, "org_type");
        CommonUtil.filter(form.getDescription(), strCondition, paramList, "description");
        CommonUtil.filter(form.getEstablishDate(), strCondition, paramList, "establish_date");
        CommonUtil.filter(form.getExpiredDate(), strCondition, paramList, "expired_date");
        CommonUtil.filter(form.getPath(), strCondition, paramList, "path");
        if (form.getId() != null) {
            strCondition.append(" AND path LIKE ? ");
            paramList.add("%" + String.format("/%s/", form.getId()) + "%");
        }
        return nativeSQL + strCondition.toString() + orderBy;
    }

    /**
     * getAllDataQuery
     * @param dfData
     * @param form
     * @return
     */
    default List<Organization> getAllDataQuery(DfData dfData, OrganizationForm form) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.list(nativeQuery, paramList, Organization.class);
    }

    default DataTableResults<Organization> getDatatables(
            DfData dfData,
            OrganizationForm form
    ) {
        List<Object> paramList = new ArrayList<>();
        String nativeQuery = buildGetDataQuery(form, paramList);
        return dfData.findPaginationQuery(nativeQuery, paramList, Organization.class);
    }

    public default List<Organization> getOrgTreeByParentId(DfData dfData, Long parentId) {
        Map<String, Object> paramList = new HashMap();
        String nativeSQL = " select o.id as id  " +
                ", o.name  as name " +
                ", o.parent_id  as parentId " +
                ", o.establish_date as establishDate  " +
                ", o.expired_date  as expiredDate " +
                ", (select count(c.id) from organization c where c.parent_id = o.id) as numChild   " +
                "from organization o   " +
                "where 1=1   " +
                "    and o.parent_id = :parentId " +
                "order by sort_order ";
        paramList.put("parentId", parentId);
        return dfData.list(nativeSQL, paramList, Organization.class);
    }

    List<Organization> findByOrgLevel(Long level);

    List<Organization> findByIdIn(List<Long> ids);

//    public List<Organization> findAllOrderByOrgLevelAscAndNameAsc();

    Organization findFirstByName(String name);
    Organization findFirstByCode(String name);

    List<Organization> findByPathContaining(String path);
    List<Organization> findByOrgLevelAndParentIdOrderByName(Long level, Long parentId);
    List<Organization> findByOrgLevelOrderByName(Long parentId);


    public default List<UpdateSortOrderOrgDTO> getAllNeedUpdateOrg(DfData dfData, List<Long> orgIds) {
        List<Object> paramList = new ArrayList<>();
        String nativeSQL = " select org.id as id  " +
                ", org.code as code  " +
                ", org.name as name  " +
                ", org.sort_order as sortOrder  " +
                ", org.org_level as orgLevel  " +
                ", org.parent_id as parentId  " +
                ", org.path as path  " +
                "from organization org  " +
                "where 1=1  ";
//                "  and ( 1=0 or org.path like '%/4/%' or org.path like '%/10/%')  " +
        StringBuilder condition = new StringBuilder(" 1=0 ");
        for (Long orgId : orgIds) {
            condition.append(" or org.path like ? ");
            paramList.add("%" + String.format("/%s/", orgId) + "%");
        }
        String orderBy = "order by org.name";
        return dfData.list(nativeSQL + " and ( " +condition.toString() + " ) " + orderBy, paramList, UpdateSortOrderOrgDTO.class);
    }


    default void updatePathAndOrder(DfData dfData, List<UpdateSortOrderOrgDTO> list) {
        String nativeSQL =" UPDATE organization SET ";
        StringBuilder sortOrder = new StringBuilder("  sort_order = CASE id ");
        StringBuilder path = new StringBuilder("  path = CASE id ");
//        StringBuilder level = new StringBuilder("  org_level = CASE id ");
        for (UpdateSortOrderOrgDTO dto: list) {
            sortOrder.append(String.format(" WHEN %s THEN '%s' ", dto.getId(), dto.getSortOrder()));
            path.append(String.format(" WHEN %s THEN '%s' ", dto.getId(), dto.getPath()));
//            level.append(String.format(" WHEN %s THEN '%s' ", dto.getId(), dto.getOrgLevel()));
        }
        sortOrder.append( " END, ");
        path.append( " END ");
        String condition = " WHERE 1=1 and id in (:ids) ";
        List<Long> orgIds = list.stream().map(UpdateSortOrderOrgDTO::getId).collect(Collectors.toList());
        Map<String, Object> paramList = new HashMap<>();
        paramList.put("ids", orgIds);
        dfData.executeUpdate( nativeSQL + sortOrder.toString() + path.toString() + condition, paramList);
    }

    @Modifying
    @Query("DELETE Organization WHERE path LIKE :path ")
    void deleteChild(@Param("path") String path);
}
