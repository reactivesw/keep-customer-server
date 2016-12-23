package io.reactivesw.catalog.category.infrastructure.validator;

import io.reactivesw.catalog.category.application.model.CategoryDraft;
import io.reactivesw.common.exception.ParametersException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Davis on 16/12/6.
 */
public final class CategoryValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CategoryValidator.class);

  /**
   * Instantiates a new Category validator.
   */
  private CategoryValidator() {
  }

  /**
   * Validate category draft.
   *
   * @param draft the draft
   */
  public static void validate(CategoryDraft draft) {

    if (draft.getName() == null
        || draft.getName().getLocalized() == null
        || draft.getName().getLocalized().isEmpty()) {
      LOG.debug("Category name can not be null");
      throw new ParametersException("Category name can not be null");
    }
  }
}
