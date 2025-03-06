
package com.sCore.modules.settings.category.controller;

import com.sCore.core.exception.SysException;
import com.sCore.core.resful.bean.Response;
import com.sCore.core.resful.constant.SearchOperation;
import com.sCore.core.resful.controller.CRUDController;
import com.sCore.core.resful.form.FilterConditionForm;
import com.sCore.core.resful.form.SearchCriteria;
import com.sCore.core.resful.service.CRUDService;
import com.sCore.core.utils.CommonUtil;
import com.sCore.modules.mngOrganization.controller.EmployeeController;
import com.sCore.modules.settings.category.bo.Category;
import com.sCore.modules.settings.category.bo.CategoryForm;
import com.sCore.modules.settings.category.service.CategoryService;
import com.sCore.modules.settings.categoryType.bo.CategoryType;
import com.sCore.modules.settings.categoryType.service.CategoryTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sCore
 * @since 03/09/2021
 * @version 1.0
 */
@Controller
@RequestMapping("/v1/category")
public class CategoryController extends CRUDController<Category, CategoryForm> {

    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private CategoryTypeService categoryTypeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }
    @Override
    protected CRUDService<Category, CategoryForm> getMainService() {
        return categoryService;
    }

    @Override
    protected Class<Category> getClassEntity() {
        return Category.class;
    }
    
    @PostMapping("/filter/{groupCode}")
    public Response findAllByFilterAndGroupCode(HttpServletRequest req
            , @RequestBody FilterConditionForm form, @PathVariable String groupCode) throws SysException {
        List<SearchCriteria> filters = form.getFilters();
        if (CommonUtil.isNullOrEmpty(filters)) {
            filters = new ArrayList<>();
        }
        CategoryType categoryType = categoryTypeService.findFirstByCode(groupCode);
        Long categoryTypeId = categoryType != null ? categoryType.getId() : -1L;
        filters.add(new SearchCriteria("categoryTypeId", categoryTypeId, SearchOperation.EQUAL.getValue(), null));
        form.setFilters(filters);
        List<Category> lstEntity = getMainService().findAllByFillter(form);
        return Response.success().withData(lstEntity);
    }
}
