package io.reactivesw.catalog.category.infrastructure.validator;

import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.common.exception.ConflictException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Created by Davis on 17/1/9.
 */
public final class CategoryVersionValidator {

  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CategoryVersionValidator.class);

  /**
   * Instantiates a new Category version validator.
   */
  private CategoryVersionValidator() {
  }

  /**
   * judge entity and version.
   *
   * @param entity  the CategoryEntity
   * @param version the version
   * @throws ConflictException when version not match
   */
  public static void validate(CategoryEntity entity, Integer version) {
    if (!Objects.equals(version, entity.getVersion())) {
      LOG.debug("Version not match, input version:{}, entity version:{}",
          version, entity.getVersion());
      throw new ConflictException("Version not match");
    }
  }
}
