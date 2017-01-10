package io.reactivesw.catalog.category.infrastructure.validator;

import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.common.exception.NotExistException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Davis on 17/1/9.
 */
public final class ParentCategoryValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ParentCategoryValidator.class);

  /**
   * Instantiates a new Parent category validator.
   */
  private ParentCategoryValidator() {
  }

  /**
   * validate if parent is null.
   * @param parentId parent id
   * @param parent parent category
   */
  public static void validate(String parentId, CategoryEntity parent) {
    if (parent == null) {
      LOG.debug("can not find parent category by id:{}", parentId);
      throw new NotExistException("Can not find parent category by id : " + parentId);
    }
  }
}
