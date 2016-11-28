package io.reactivesw.catalog.categories.services;

import io.reactivesw.catalog.categories.entities.CategoryEntity;
import io.reactivesw.catalog.categories.models.Category;
import io.reactivesw.catalog.categories.models.mapper.CategoryMapper;
import io.reactivesw.catalog.categories.repositories.CategoryRepository;
import io.reactivesw.common.exceptions.NotExistException;
import io.reactivesw.common.exceptions.ParametersException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
   * Category Repository.
   */
  @Autowired
  private transient CategoryRepository categoryRepository;

  /**
   * Gets category by id.
   *
   * @param id the id
   * @return the category by id
   */
  public Category getCategoryById(String id) {
    LOG.debug("enter getCategoryById, id is {}", id);
    CategoryEntity categoryEntity = categoryRepository.findOne(id);
    if (categoryEntity == null) {
      LOG.debug("fail getCategoryById, can not find category by id {}", id);
      throw new NotExistException();
    }
    LOG.debug("end getCategoryById, id is {}, get Category {}", id, categoryEntity.toString());
    return CategoryMapper.entityToCategory(categoryEntity);
  }

  /**
   * Delete category by id and version.
   *
   * @param id      the id
   * @param version the version
   */
  public void deleteCategory(String id, Integer version) {
    LOG.debug("enter deleteCategory, id is {}, version is {}", id, version);
    CategoryEntity entity = categoryRepository.findOne(id);
    if (entity == null) {
      LOG.debug("fail deleteCategory, can not find category by id {}", id);
      throw new NotExistException();
    }
    if (!version.equals(entity.getVersion())) {
      LOG.debug("fail deleteCategory, version not match,delete version is {}, entity version is {}",
          version, entity.getVersion());
      throw new ParametersException();
    }
    categoryRepository.delete(id);
    LOG.debug("end deleteCategory, id is {}, version is {}", id, version);
  }
}
