package io.reactivesw.catalog.categories.applications.controllers;

import static io.reactivesw.routes.Router.CATEGORIES_WITH_ID;
import static io.reactivesw.routes.Router.CATEGORY_ALL;
import static io.reactivesw.routes.Router.CATEGORY_ID;

import io.reactivesw.catalog.categories.applications.models.Category;
import io.reactivesw.catalog.categories.applications.models.CategoryDraft;
import io.reactivesw.catalog.categories.domains.services.CategoryService;
import io.reactivesw.common.exceptions.ParametersException;
import io.reactivesw.common.models.UpdateRequest;
import io.reactivesw.common.models.QueryConditions;

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
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
   * Gets category by id.
   *
   * @param id the id
   * @return the category by id
   */
  @ApiOperation(value = "Get CategoryEntity By Id")
  @GetMapping(CATEGORIES_WITH_ID)
  public Category getCategoryById(@PathVariable(value = CATEGORY_ID)
                                  @ApiParam(value = "CategoryEntity ID", required = true)
                                      String id) {
    LOG.debug("enter getCategoryById, id is {}", id);
    Category category = categoryService.getCategoryById(id);
    LOG.debug("end getCategoryById, get category : {}", category.toString());
    return category;
  }

  /**
   * Query categories list.
   *
   * @return the list
   */
  @ApiOperation(value = "Get Categories")
  @GetMapping(CATEGORY_ALL)
  //TODO
  public List<Category> queryCategories(QueryConditions query) {
    LOG.debug("query parameters: {}", query.toString());
    return null;
  }

  /**
   * Create category category.
   *
   * @param categoryDraft the draft
   * @return the category
   */
  @ApiOperation(value = "Create CategoryEntity")
  @PostMapping(CATEGORY_ALL)
  public Category createCategory(@RequestBody
                                 @ApiParam(value = "CategoryEntity Draft", required = true)
                                     CategoryDraft categoryDraft) {
    LOG.debug("create category : {}", categoryDraft.toString());
    //TODO slug 判断规则
    if (categoryDraft.getName() == null
        || categoryDraft.getName().getLocalized().isEmpty()
        || categoryDraft.getSlug() == null
        || categoryDraft.getSlug().getLocalized().isEmpty()
        ) {
      throw new ParametersException();
    }
    Category category = categoryService.createCategory(categoryDraft);
    LOG.debug("end createCategory, saved category is {}", category.toString());
    return category;
  }

  /**
   * Update category category.
   *
   * @param id     the id
   * @param updateRequest the fields
   * @return the category
   */
  @ApiOperation(value = "Update CategoryEntity")
  @PutMapping(CATEGORIES_WITH_ID)
  //TODO
  public Category updateCategory(@PathVariable(value = CATEGORY_ID)
                                 @ApiParam(value = "CategoryEntity ID", required = true)
                                     String id,
                                 @RequestBody
                                 @ApiParam(value = "CategoryEntity Update Fields", required = true)
                                     UpdateRequest updateRequest) throws Exception {
    LOG.debug("update category : {}", updateRequest.toString());
    List<Object> objs = updateRequest.getActions();
    String loObj = objs.get(0).toString();
    LOG.debug("action  : {}", loObj);

    return null;
  }

  /**
   * Delete category.
   *
   * @param version the version
   */
  @ApiOperation(value = "Delete CategoryEntity By Id")
  @DeleteMapping(value = CATEGORIES_WITH_ID)
  public void deleteCategory(@PathVariable(value = CATEGORY_ID)
                             @ApiParam(value = "CategoryEntity ID", required = true)
                                 String id,
                             Integer version) {
    LOG.debug("enter deleteCategory, id is {}, version is {}", id, version);
    categoryService.deleteCategory(id, version);
    LOG.debug("end deleteCategory, id is {}, version is {}", id, version);
  }
}
