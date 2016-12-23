package io.reactivesw.catalog.product.infrastructure.validator;

import io.reactivesw.catalog.product.domain.entity.ProductEntity;
import io.reactivesw.common.exception.ConflictException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Davis on 16/12/23.
 */
public final class SlugValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(SlugValidator.class);

  /**
   * Instantiates a new Slug validator.
   */
  private SlugValidator() {
  }

  /**
   * validate slug.
   *
   * @param slug     the slug.
   * @param products the products.
   */
  public static void validate(String slug, List<ProductEntity> products) {
    if (products != null) {
      products.parallelStream().forEach(
          product -> {
            validate(slug, product);
          }
      );
    }
  }

  /**
   * validate slug.
   *
   * @param slug    the slug
   * @param product the product
   */
  private static void validate(String slug, ProductEntity product) {
    if (StringUtils.equals(slug, product.getMasterData().getCurrent().getSlug())
        || StringUtils.equals(slug, product.getMasterData().getStaged().getSlug())) {
      LOG.debug("slug : {} has already exists", slug);
      throw new ConflictException("slug has already exists");
    }
  }
}
