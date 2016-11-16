package io.reactivesw.customer.server.catalog.controllers;

import io.reactivesw.customer.server.catalog.models.Category;
import io.reactivesw.customer.server.catalog.services.CategoryService;
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

import javax.validation.constraints.NotNull;

import static io.reactivesw.customer.server.routes.Router.CATEGORY_ALL;
import static io.reactivesw.customer.server.routes.Router.CATEGORY_GET_BY_ID;
import static io.reactivesw.customer.server.routes.Router.CATEGORY_ID;

/**
 * Category Controller.
 * Created by Davis on 16/11/15.
 */
@RestController
public class CategoryController {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

  /**
   * category service.
   */
  @Autowired
  private transient CategoryService categoryService;

  /**
   * get all categories.
   *
   * @return list of Category
   */
  @ApiOperation(value = "Get all categories")
  @GetMapping(value = CATEGORY_ALL)
  public List<Category> getAllCategories() {
    LOG.debug("enter getAllCategories");
    List<Category> categories = categoryService.findAllCategories();
    LOG.debug("end getAllCategories, get {} categories", categories.size());
    return categories;
  }

  /**
   * get category by id.
   *
   * @param id id for category
   * @return Category
   */
  @ApiOperation(value = "get category by id")
  @GetMapping(value = CATEGORY_GET_BY_ID)
  public Category getCategoryById(@PathVariable(value = CATEGORY_ID)
                                  @ApiParam(name = CATEGORY_ID,
                                      value = "id for category", required = true)
                                  @NotNull int id) {
    LOG.debug("enter getCategoryById, id is {}", id);
    Category category = categoryService.findCategoryById(id);
    LOG.debug("end getCategoryById, get {}", category.toString());
    return category;
  }

  /**
   * Create category.
   *
   * @param category the category
   * @return the new category
   */
  @ApiOperation(value = "create category")
  @PostMapping(value = CATEGORY_ALL)
  public Category createCategory(@RequestBody Category category) {
    LOG.debug("enter createCategory, request body is {}", category);
    Category savedCategory = categoryService.saveCategory(category);
    LOG.debug("end createCategory, save as {}", savedCategory);
    return savedCategory;
  }

  /**
   * Delete category.
   *
   * @param id the id
   */
  @ApiOperation(value = "delete category")
  @DeleteMapping(value = CATEGORY_GET_BY_ID)
  public void deleteCategory(@PathVariable(value = CATEGORY_ID)
                             @ApiParam(name = CATEGORY_ID,
                                 value = "id for category", required = true)
                             @NotNull int id) {
    LOG.debug("enter deleteCategory, id is {}", id);
    categoryService.deleteCategoryById(id);
    LOG.debug("end deleteCategory");
  }

  /**
   * Update category.
   *
   * @param id       the id
   * @param category the category
   * @return the updated category
   */
  @ApiOperation(value = "update category")
  @PutMapping(value = CATEGORY_GET_BY_ID)
  public Category updateCategory(@PathVariable(value = CATEGORY_ID)
                                 @ApiParam(name = CATEGORY_ID,
                                     value = "id for category", required = true)
                                 @NotNull int id,
                                 @RequestBody Category category) {
    LOG.debug("enter updateCategory, id is {}, need to update Category is {}", id, category);
    Category updatedCategory = categoryService.updateCategory(id, category);
    LOG.debug("end updateCategory, updated Category is {}", updatedCategory);
    return updatedCategory;
  }
}
