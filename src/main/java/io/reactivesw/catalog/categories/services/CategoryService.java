package io.reactivesw.catalog.categories.services;

import io.reactivesw.catalog.categories.entities.CategoryEntity;
import io.reactivesw.catalog.categories.models.Category;
import io.reactivesw.catalog.categories.models.mapper.CategoryMapper;
import io.reactivesw.catalog.categories.repositories.CategoryRepository;
import io.reactivesw.common.exceptions.NotExistException;

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
      LOG.debug("fail to getCategoryById, can not find category by id {}", id);
      throw new NotExistException();
    }
    LOG.debug("end getCategoryById, id is {}, get Category {}", id, categoryEntity.toString());
    return CategoryMapper.entityToCategory(categoryEntity);
  }
}
