package io.reactivesw.catalog.category.application.controller;

import static io.reactivesw.route.CategoryRouter.CATEGORY_ID;
import static io.reactivesw.route.CategoryRouter.CATEGORY_ROOT;
import static io.reactivesw.route.CategoryRouter.CATEGORY_WITH_ID;

import io.reactivesw.catalog.category.application.model.Category;
import io.reactivesw.catalog.category.application.model.CategoryDraft;
import io.reactivesw.catalog.category.application.model.action.CategoryUpdateAction;
import io.reactivesw.catalog.category.domain.service.CategoryService;
import io.reactivesw.catalog.category.infrastructure.validator.CategoryNameValidator;
import io.reactivesw.common.model.PagedQueryResult;
import io.reactivesw.common.model.QueryConditions;
import io.reactivesw.common.model.UpdateRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Davis on 16/11/18.
 */
@ApiModel
@RestController
public class CategoryController {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

  /**
   * CategoryEntity Service.
   */
  @Autowired
  private transient CategoryService categoryService;

  /**
   * Create category category.
   *
   * @param categoryDraft the draft
   * @return the category
   */
  @ApiOperation(value = "Create CategoryEntity")
  @PostMapping(CATEGORY_ROOT)
  public Category createCategory(@RequestBody
                                 @ApiParam(value = "CategoryEntity Draft", required = true)
                                 @Valid CategoryDraft categoryDraft) {
    LOG.debug("create category : {}", categoryDraft.toString());

    CategoryNameValidator.validateNull(categoryDraft);

    Category category = categoryService.createCategory(categoryDraft);

    LOG.debug("end createCategory, saved category is {}", category.toString());

    return category;
  }

  /**
   * Delete category.
   *
   * @param version the version
   */
  @ApiOperation(value = "Delete CategoryEntity By Id")
  @DeleteMapping(value = CATEGORY_WITH_ID)
  public void deleteCategory(@PathVariable(value = CATEGORY_ID)
                             @ApiParam(value = "CategoryEntity ID", required = true)
                                 String id,
                             @RequestParam
                             @ApiParam(value = "CategoryEntity Version", required = true)
                                 Integer version) {
    LOG.debug("enter deleteProduct, id is {}, version is {}", id, version);

    categoryService.deleteCategory(id, version);

    LOG.debug("end deleteProduct, id is {}, version is {}", id, version);
  }

  /**
   * Update category category.
   *
   * @param id            the id
   * @param updateRequest the fields
   * @return the category
   */
  @ApiOperation(value = "Update CategoryEntity")
  @PutMapping(CATEGORY_WITH_ID)
  public Category updateCategory(@PathVariable(value = CATEGORY_ID)
                                 @ApiParam(value = "CategoryEntity ID", required = true)
                                     String id,
                                 @RequestBody
                                 @ApiParam(value = "CategoryEntity Update Fields", required = true)
                                 @Valid UpdateRequest<CategoryUpdateAction> updateRequest) {
    LOG.debug("enter updateCategory,id is {}, update request is {}", id, updateRequest.toString());

    Category result = categoryService.updateCategory(id, updateRequest.getVersion(),
        updateRequest.getActions());

    LOG.debug("end updateCategory, updated Category is {}", result.toString());

    return result;
  }

  /**
   * Gets category by id.
   *
   * @param id the id
   * @return the category by id
   */
  @ApiOperation(value = "Get CategoryEntity By Id")
  @GetMapping(CATEGORY_WITH_ID)
  public Category getCategoryById(@PathVariable(value = CATEGORY_ID)
                                  @ApiParam(value = "CategoryEntity ID", required = true)
                                      String id) {
    LOG.debug("enter getCategoryById, id is {}", id);
    Category category = categoryService.getCategoryById(id);
    LOG.debug("end getCategoryById, get category : {}", category.toString());
    return category;
  }

  /**
   * Query category list.
   *
   * @return the list
   */
  @ApiOperation(value = "Get Categories")
  @GetMapping(CATEGORY_ROOT)
  public PagedQueryResult<Category> queryCategories(QueryConditions query) {
    LOG.debug("enter queryCategories, query parameters: {}", query.toString());

    PagedQueryResult<Category> result = categoryService.queryCategories(query);

    LOG.debug("end queryCategories, query result is : {}", result.toString());

    return result;
  }
}
