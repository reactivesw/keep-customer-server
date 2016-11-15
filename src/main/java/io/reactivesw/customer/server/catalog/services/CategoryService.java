package io.reactivesw.customer.server.catalog.services;

import io.reactivesw.customer.server.catalog.entities.CategoryEntity;
import io.reactivesw.customer.server.catalog.models.Category;
import io.reactivesw.customer.server.catalog.models.mapper.CategoryMapper;
import io.reactivesw.customer.server.catalog.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Category Service.
 * Created by rai on 16/11/13.
 */
@Service
public class CategoryService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

  /**
   * Category Repository.
   */
  @Autowired
  private transient CategoryRepository categoryRepository;


  /**
   * Save category.
   *
   * @param category the category
   * @return the saved category
   */
  public Category saveCategory(Category category) {
    LOG.debug("enter saveCategory");
    String name = category.getName();
    String description = category.getName();
    int parentId = category.getParentId() == null ? -1 : category.getParentId();
    CategoryEntity categoryEntity = new CategoryEntity(name, description, parentId);
    categoryEntity = categoryRepository.save(categoryEntity);
    Category savedCategory = CategoryMapper.createModel(categoryEntity);
    LOG.debug("end saveCategory, new Category is {}", savedCategory.toString());
    return savedCategory;
  }

  /**
   * Find category by id category.
   *
   * @param id the id
   * @return the category
   */
  public Category findCategoryById(int id) {
    LOG.debug("enter findCategoryById, id is {}", id);
    Category category = new Category();
    CategoryEntity categoryEntity = categoryRepository.findOne(id);
    if (categoryEntity != null) {
      category = CategoryMapper.createModel(categoryEntity);
    }
    LOG.debug("end findCategoryById, get {}", category.toString());
    return category;
  }

  /**
   * Find all top categories list.
   *
   * @return the list
   */
  public List<Category> findAllCategories() {
    LOG.debug("enter findAllCategories");
    List<CategoryEntity> allCategories = categoryRepository.findAll();
    List<Category> categories = new ArrayList<>();
    if (allCategories != null) {
      categories = CategoryMapper.createModelList(allCategories);
    }
    LOG.debug("end findAllCategories, get {} categories", categories.size());
    return categories;
  }

  /**
   * Delet category by id.
   *
   * @param id the id
   */
  public void deleteCategoryById(int id) {
    //TODO 返回结果问题,ID不存在问题
    LOG.debug("enter deleteCategoryById, id is {}", id);
    List<Integer> ids = new ArrayList<>();
    ids.add(id);
    deleteCategoryByIds(ids);
    //TODO update cache or send a message
    LOG.debug("end deleteCategoryById, id is {}", id);
  }


  /**
   * Delete category by ids.
   *
   * @param ids the ids
   */
  @Transactional
  private void deleteCategoryByIds(List<Integer> ids){
    //1. find all category
    List<CategoryEntity> categoryEntities = categoryRepository.findAll(ids);
    //2. delete all category
    categoryRepository.delete(categoryEntities);
    //TODO send a message
    //3. query subCategory by ids
    List<CategoryEntity> subCategoryEntities = categoryRepository.queryIdByParentId(ids);

    if (subCategoryEntities != null && !subCategoryEntities.isEmpty()) {
      //get all ids
      List<Integer> subCategoryIds = new ArrayList<>();
      for(CategoryEntity category : subCategoryEntities){
        subCategoryIds.add(category.getId());
      }
      deleteCategoryByIds(subCategoryIds);
    }
  }

  /**
   * Update category.
   *
   * @param id       the id
   * @param category the category
   * @return the updated category
   */
  public Category updateCategory(int id, Category category) {
    //TODO 需要判断id是否存在, 和parentId与id重复的情况吗?
    LOG.debug("enter updateCategory, id is {}, need to update Category is {}", id, category);
    CategoryEntity categoryEntity = categoryRepository.findOne(id);
    //mapper model to entity
    categoryEntity = CategoryMapper.updateEntity(category, categoryEntity);
    //update
    CategoryEntity updatedCategory = categoryRepository.save(categoryEntity);
    LOG.debug("end updateCategory, updated Category is {}", updatedCategory);
    return CategoryMapper.createModel(updatedCategory);
  }
}
