package io.reactivesw.catalog.category.domain.service;

import com.google.common.collect.Lists;

import io.reactivesw.catalog.category.application.model.Category;
import io.reactivesw.catalog.category.application.model.CategoryDraft;
import io.reactivesw.catalog.category.application.model.mapper.CategoryMapper;
import io.reactivesw.catalog.category.application.model.mapper.CategoryUpdateMapper;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.catalog.category.infrastructure.repository.CategoryRepository;
import io.reactivesw.catalog.category.infrastructure.validator.CategoryNameValidator;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.PagedQueryResult;
import io.reactivesw.common.model.QueryConditions;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.UpdateAction;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    List<CategoryEntity> sameRootCategories = categoryRepository.queryCategoryByParent(parentId);
    CategoryNameValidator.validateEqual(categoryDraft.getName(), sameRootCategories);

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

    List<CategoryEntity> tatalCategoryEitities = Lists.newArrayList(entity);
    List<CategoryEntity> subCategories = categoryRepository.querySubCategoriesByAncestorId(id);
    if (subCategories != null && !subCategories.isEmpty()) {
      tatalCategoryEitities.addAll(subCategories);
    }

    categoryRepository.delete(tatalCategoryEitities);

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

    actions.parallelStream().forEach(action -> {
      CategoryUpdateMapper.getMapper(action.getClass())
        .handle(entity, action);
    });

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
   * Query category.
   *
   * @param queryConditions the QueryConditions
   * @return the paged query result
   */
// TODO: 16/12/13 queryconditions
  public PagedQueryResult<Category> queryCategories(QueryConditions queryConditions) {
    LOG.debug("enter queryCategories, QueryConditions is : {}", queryConditions.toString());

    List<CategoryEntity> entities = categoryRepository.findAll();

    List<Category> result = CategoryMapper.entityToModel(entities);

    LOG.debug("end queryCategories, get Categories : {}", result);

    PagedQueryResult<Category> pagedQueryResult = new PagedQueryResult<>();
    pagedQueryResult.setResults(result);

    return pagedQueryResult;
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
   * validateNull parent category.
   *
   * @param parentId parent id
   * @param parent   parent category
   * @throws ParametersException when parent category is null
   */
  private void validateParentCategory(String parentId, CategoryEntity parent) {
    if (parent == null) {
      LOG.debug("can not find parent category by id:{}", parentId);
      throw new NotExistException("Can not find parent category by id : " + parentId);
    }
  }
}
