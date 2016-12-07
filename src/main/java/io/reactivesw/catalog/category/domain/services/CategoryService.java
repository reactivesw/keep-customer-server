package io.reactivesw.catalog.category.domain.services;

import com.google.common.collect.Lists;

import io.reactivesw.catalog.category.application.model.Category;
import io.reactivesw.catalog.category.application.model.CategoryDraft;
import io.reactivesw.catalog.category.application.model.mapper.CategoryMapper;
import io.reactivesw.catalog.category.application.model.mapper.CategoryUpdateMapper;
import io.reactivesw.catalog.category.domain.entities.CategoryEntity;
import io.reactivesw.catalog.category.infrastructure.repository.CategoryRepository;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.UpdateAction;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
   * Create category.
   *
   * @param categoryDraft the category draft
   * @return the category
   */
  @Transactional
  public Category createCategory(CategoryDraft categoryDraft) {
    LOG.debug("enter createCategory, CategoryDraft is {}", categoryDraft.toString());

    String parentId = "";
    List<String> ancestors = new ArrayList<>();

    Reference parentReference = categoryDraft.getParent();
    if (parentReference != null && StringUtils.isNotBlank(parentReference.getId())) {
      parentId = parentReference.getId();
      CategoryEntity parent = getParentCategory(parentId);
      ancestors = setAncestors(parentId, parent);
    }
    validateCategoryName(categoryDraft.getName(), parentId);

    CategoryEntity entity = CategoryMapper.modelToEntity(categoryDraft);
    entity.setParent(parentId);
    entity.setAncestors(ancestors);

    CategoryEntity savedEntity = categoryRepository.save(entity);

    Category category = CategoryMapper.entityToModel(savedEntity);
    LOG.debug("end createCategory, new CategoryEntity is: {}", category.toString());
    //TODO send message
    return category;
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
    LOG.debug("enter deleteCategory, id:{}, version:{}", id, version);

    CategoryEntity entity = this.getById(id);
    validateVersion(entity, version);

    List<String> subCategoryIds = categoryRepository.queryCategoryIdsByAncestorId(id);
    List<String> totalCategoryIds = Lists.newArrayList(id);
    if (subCategoryIds != null && !subCategoryIds.isEmpty()) {
      totalCategoryIds.addAll(subCategoryIds);
    }
    categoryRepository.deleteCategoryById(totalCategoryIds);

    //TODO send message for:
    // remove from all those product that had that category assigned in their ProductData

    LOG.debug("end deleteCategory, id:{}, version:{}", id, version);
  }

  /**
   * Update category.
   *
   * @param id      the id
   * @param version the update request
   * @param actions the update action
   * @return the category
   */
  @Transactional
  public Category updateCategory(String id, Integer version, List<UpdateAction> actions) {
    LOG.debug("enter updateCategory, id is {}, version is {}, update action is {}",
        id, version, actions);

    CategoryEntity entity = getById(id);
    validateVersion(entity, version);

    actions.parallelStream().forEach(action -> CategoryUpdateMapper.getMapper(action.getClass())
        .setAction(entity, action));

    CategoryEntity updatedEntity = categoryRepository.save(entity);
    //TODO send message, if slug be updated
    Category result = CategoryMapper.entityToModel(updatedEntity);

    LOG.debug("end updateCategory, updated Category is {}", result);
    return result;
  }

  /**
   * Gets category by id.
   *
   * @param id the id
   * @return the category by id
   * @throws NotExistException if the can not find CategoryEntity by the id
   */
  public Category getCategoryById(String id) {
    LOG.debug("enter getCategoryById, id is {}", id);
    return CategoryMapper.entityToModel(getById(id));
  }

  /**
   * Gets category by id.
   *
   * @param id the id
   * @return the category by id
   * @throws NotExistException if the can not find CategoryEntity by the id
   */
  private CategoryEntity getById(String id) {
    LOG.debug("enter getById, id is {}", id);

    CategoryEntity categoryEntity = categoryRepository.findOne(id);

    if (categoryEntity == null) {
      LOG.debug("fail getById, can not find category by id:{}", id);
      throw new NotExistException("can not find category by id:" + id);
    }

    LOG.debug("end getById, id is {}, get CategoryEntity:{}",
        id, categoryEntity.toString());
    return categoryEntity;
  }

  /**
   * judge entity and version.
   *
   * @param entity  the CategoryEntity
   * @param version the version
   * @throws NotExistException   when entity is null
   * @throws ParametersException when version not match
   */
  private void validateVersion(CategoryEntity entity, Integer version) {

    if (!Objects.equals(version, entity.getVersion())) {
      LOG.debug("Version not match, input version:{}, entity version:{}",
          version, entity.getVersion());
      throw new ParametersException("Version not match");
    }

  }

  /**
   * Gets parent category.
   *
   * @param parentId the parent id
   * @return the parent category
   */
  private CategoryEntity getParentCategory(String parentId) {
    CategoryEntity parent = categoryRepository.findOne(parentId);
    validateParentCategory(parentId, parent);
    return parent;
  }

  /**
   * set ancestors.
   *
   * @param parentId the parent id
   * @param parent   the parent category
   * @return list of ancestors
   */
  private List<String> setAncestors(String parentId, CategoryEntity parent) {
    List<String> ancestors = Lists.newArrayList();
    if (parent.getAncestors() != null) {
      ancestors = Lists.newArrayList(parent.getAncestors());
    }
    ancestors.add(parentId);
    return ancestors;
  }

  /**
   * validate parent category.
   *
   * @param parentId parent id
   * @param parent   parent category
   * @throws ParametersException when parent category is null
   */
  private void validateParentCategory(String parentId, CategoryEntity parent) {
    if (parent == null) {
      LOG.debug("can not find parent category by id:{}", parentId);
      throw new ParametersException("Can not find parent category by id:" + parentId);
    }
  }

  /**
   * judge category name, if equals to exist name, should return exception.
   *
   * @param name     name to validate
   * @param parentId the parent id
   * @throws ParametersException if name has exist
   */
  private void validateCategoryName(LocalizedString name, String parentId) {
    List<CategoryEntity> sameRootCategories = categoryRepository.queryCategoryByParent(parentId);
    List<LocalizedStringEntity> categoryNames = getAllCategoryNames(sameRootCategories);
    Map<String, String> localizedName = name.getLocalized();
    for (Map.Entry entry : localizedName.entrySet()) {
      String key = entry.getKey().toString();
      String value = entry.getValue().toString();
      for (LocalizedStringEntity categoryName : categoryNames) {
        if (key.equals(categoryName.getLanguage()) && value.equals(categoryName.getText())) {
          LOG.debug("can not create category with same name : {}, key: {}", value, key);
          throw new ParametersException("Can not create category with same name");
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
