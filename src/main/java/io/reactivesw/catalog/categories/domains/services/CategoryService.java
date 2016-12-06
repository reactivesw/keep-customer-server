package io.reactivesw.catalog.categories.domains.services;

import com.google.common.collect.Lists;

import io.reactivesw.catalog.categories.applications.models.Category;
import io.reactivesw.catalog.categories.applications.models.CategoryDraft;
import io.reactivesw.catalog.categories.applications.models.mapper.CategoryMapper;
import io.reactivesw.catalog.categories.applications.models.mapper.CategoryUpdateMapper;
import io.reactivesw.catalog.categories.domains.entities.CategoryEntity;
import io.reactivesw.catalog.categories.infrastructure.repositories.CategoryRepository;
import io.reactivesw.common.entities.LocalizedStringEntity;
import io.reactivesw.common.exceptions.NotExistException;
import io.reactivesw.common.exceptions.ParametersException;
import io.reactivesw.common.models.LocalizedString;
import io.reactivesw.common.models.Reference;
import io.reactivesw.common.models.UpdateAction;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

/**
 * Created by Davis on 16/11/28.
 */
@Service
public class CategoryService {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

  /**
   * CategoryEntity Repository.
   */
  @Autowired
  private transient CategoryRepository categoryRepository;

  /**
   * Gets category by id.
   *
   * @param id the id
   * @return the category by id
   * @throws NotExistException if the can not find CategoryEntity by the id
   */
  public Category getCategoryById(String id) {
    LOG.debug("enter getCategoryById, id is {}", id);
    CategoryEntity categoryEntity = categoryRepository.findOne(id);
    if (categoryEntity == null) {
      LOG.debug("fail getCategoryById, can not find category by id {}", id);
      throw new NotExistException();
    }
    LOG.debug("end getCategoryById, id is {}, get CategoryEntity {}",
        id, categoryEntity.toString());
    return CategoryMapper.entityToCategory(categoryEntity);
  }

  /**
   * Delete category by id and version.
   *
   * @param id      the id
   * @param version the version
   * @throws NotExistException   if the can not find CategoryEntity by the id.
   * @throws ParametersException if the version can not match.
   */
  @Transactional
  public void deleteCategory(String id, Integer version) {
    LOG.debug("enter deleteCategory, id is {}, version is {}", id, version);
    CategoryEntity entity = categoryRepository.findOne(id);
    judgeCategoryVersion(id, entity, version);
    List<String> subCategoryIds = categoryRepository.queryCategoryIdsByAncestorId(id);
    List<String> totalCategoryIds = Lists.newArrayList(id);
    if (subCategoryIds != null && !subCategoryIds.isEmpty()) {
      totalCategoryIds.addAll(subCategoryIds);
    }
    categoryRepository.deleteCategoryById(totalCategoryIds);

    //TODO remove from all those products that had that category assigned in their ProductData
    //delete by id and subCategoryIds

    LOG.debug("end deleteCategory, id is {}, version is {}", id, version);
  }


  /**
   * Update category.
   *
   * @param id            the id
   * @param version       the update request
   * @param updateActions the update actions
   * @return the category
   */
  public Category updateCategory(String id, Integer version, List<UpdateAction> updateActions) {
    LOG.debug("enter updateCategory, id is {}, version is {}, update actions is {}",
        id, version, updateActions);
    CategoryEntity entity = categoryRepository.findOne(id);
    judgeCategoryVersion(id, entity, version);
    for (UpdateAction updateAction : updateActions) {
      entity = CategoryUpdateMapper.updateCategoryEntity(updateAction, entity);
    }

    CategoryEntity updatedEntity = categoryRepository.save(entity);
    Category result = CategoryMapper.entityToCategory(updatedEntity);
    LOG.debug("end updateCategory, updated Category is {}", result);
    return result;
  }

  /**
   * judge entity and version.
   *
   * @param id      the id
   * @param entity  the CategoryEntity
   * @param version the version
   * @throws NotExistException   when entity is null
   * @throws ParametersException when version not match
   */
  private void judgeCategoryVersion(String id, CategoryEntity entity, Integer version) {
    if (entity == null) {
      LOG.debug("fail deleteCategory, can not find category by id {}", id);
      throw new NotExistException();
    }
    if (!version.equals(entity.getVersion())) {
      LOG.debug("fail deleteCategory, version not match,delete version is {}, entity version is {}",
          version, entity.getVersion());
      throw new ParametersException();
    }
  }

  /**
   * Create category.
   *
   * @param categoryDraft the category draft
   * @return the category
   */
  public Category createCategory(CategoryDraft categoryDraft) {
    LOG.debug("enter createCategory, CategoryDraft is {}", categoryDraft.toString());

    Reference parentReference = categoryDraft.getParent();
    String parentId = "";
    List<String> ancestors = new ArrayList<>();

    if (parentReference != null && !StringUtils.isBlank(parentReference.getId())) {
      parentId = parentReference.getId();
      CategoryEntity parent = categoryRepository.findOne(parentId);

      if (parent == null) {
        throw new ParametersException();
      }

      ancestors = Lists.newArrayList(parent.getAncestors());
      ancestors.add(parentId);
    }

    List<CategoryEntity> topCategories = categoryRepository.queryCategoryByParent(parentId);
    judgeCategoryName(topCategories, categoryDraft.getName());

    CategoryEntity entity = CategoryMapper.draftToCategoryEntity(categoryDraft);

    entity.setParent(parentId);
    entity.setAncestors(ancestors);

    CategoryEntity savedCategory = categoryRepository.save(entity);
    Category category = CategoryMapper.entityToCategory(savedCategory);

    LOG.debug("end createCategory, new CategoryEntity is {}", category.toString());
    return category;
  }

  /**
   * judge category name, if equals to exist name, should return exception.
   *
   * @param categories list of CategoryEntity
   * @param name       name to judge
   * @throws ParametersException if name has exist
   */
  private void judgeCategoryName(List<CategoryEntity> categories, LocalizedString name) {
    List<LocalizedStringEntity> categoryNames = getAllCategoryNames(categories);
    Map<String, String> localizedName = name.getLocalized();
    for (Map.Entry entry : localizedName.entrySet()) {
      String key = entry.getKey().toString();
      String value = entry.getValue().toString();
      for (LocalizedStringEntity categoryName : categoryNames) {
        if (key.equals(categoryName.getLanguage()) && value.equals(categoryName.getText())) {
          throw new ParametersException();
        }
      }
    }
  }

  /**
   * get all names from list of CategoryEntity.
   *
   * @param categories list of CategoryEntity
   * @return list of LocalizedStringEntity
   */
  private List<LocalizedStringEntity> getAllCategoryNames(List<CategoryEntity> categories) {
    List<LocalizedStringEntity> subCategoryNames = new ArrayList<>();
    if (categories != null) {
      categories.stream()
          .map(categoryEntity -> categoryEntity.getName())
          .forEach(subCategoryNames::addAll);
    }
    return subCategoryNames;
  }
}
