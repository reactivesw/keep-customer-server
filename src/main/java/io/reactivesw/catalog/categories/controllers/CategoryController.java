package io.reactivesw.catalog.categories.controllers;

import static io.reactivesw.routes.Router.CATEGORIES_WITH_ID;
import static io.reactivesw.routes.Router.CATEGORY_ALL;
import static io.reactivesw.routes.Router.CATEGORY_ID;

import io.reactivesw.catalog.categories.models.Category;
import io.reactivesw.catalog.categories.models.CategoryDraft;
import io.reactivesw.catalog.categories.services.CategoryService;
import io.reactivesw.common.models.Field;
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
   * Category Service.
   */
  @Autowired
  private transient CategoryService categoryService;

  /**
   * Gets category by id.
   *
   * @param id the id
   * @return the category by id
   */
  @ApiOperation(value = "Get Category By Id")
  @GetMapping(CATEGORIES_WITH_ID)
  public Category getCategoryById(@PathVariable(value = CATEGORY_ID)
                                  @ApiParam(value = "Category ID", required = true) String id) {
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
  public List<Category> queryCategories(QueryConditions query) {
    LOG.debug("query parameters: {}", query.toString());
    return null;
  }

  /**
   * Create category category.
   *
   * @param draft the draft
   * @return the category
   */
  @ApiOperation(value = "Create Category")
  @PostMapping(CATEGORY_ALL)
  public Category createCategory(@RequestBody
                                 @ApiParam(value = "Category Draft", required = true)
                                     CategoryDraft draft) {
    LOG.debug("create category : {}", draft.toString());
    return null;
  }

  /**
   * Update category category.
   *
   * @param id     the id
   * @param fields the fields
   * @return the category
   */
  @ApiOperation(value = "Update Category")
  @PutMapping(CATEGORIES_WITH_ID)
  public Category updateCategory(@PathVariable(value = CATEGORY_ID)
                                 @ApiParam(value = "Category ID", required = true)
                                     String id,
                                 @RequestBody
                                 @ApiParam(value = "Category Update Fields", required = true)
                                     Field fields) throws Exception {
    LOG.debug("update category : {}", fields.toString());
    List<Object> objs = fields.getActions();
    String loObj = objs.get(0).toString();
    LOG.debug("action  : {}", loObj);

    return null;
  }

  /**
   * Delete category.
   *
   * @param version the version
   */
  @ApiOperation(value = "Delete Category By Id")
  @DeleteMapping(value = CATEGORIES_WITH_ID)
  public void deleteCategory(@PathVariable(value = CATEGORY_ID)
                             @ApiParam(value = "Category ID", required = true)
                                 String id,
                             Integer version) {
    LOG.debug("enter deleteCategory, id is {}, version is {}", id, version);
    LOG.debug("end deleteCategory, id is {}, version is {}", id, version);
  }
}
