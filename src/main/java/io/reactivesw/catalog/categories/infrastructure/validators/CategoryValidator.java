package io.reactivesw.catalog.categories.infrastructure.validators;

import io.reactivesw.catalog.categories.applications.models.CategoryDraft;
import io.reactivesw.common.exceptions.ParametersException;
import io.reactivesw.common.models.UpdateAction;
import io.reactivesw.common.models.UpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
  public static void validateCategoryDraft(CategoryDraft draft) {
    if (draft.getName() == null
        || draft.getName().getLocalized() == null
        || draft.getName().getLocalized().isEmpty()
        || draft.getSlug() == null
        || draft.getSlug().getLocalized() == null
        || draft.getSlug().getLocalized().isEmpty()) {
      LOG.debug("draft name or slug must not be null");
      throw new ParametersException();
    }
    //TODO slug 判断规则
  }

  /**
   * Validate update request.
   *
   * @param updateRequest the update request
   */
  public static void validateUpdateRequest(UpdateRequest updateRequest) {
    validateVersion(updateRequest.getVersion());
    List<UpdateAction> updateActions = updateRequest.getActions();
    if (updateActions == null || updateActions.isEmpty()) {
      LOG.debug("update actions must not be null");
      throw new ParametersException();
    }
    //TODO judge request
  }

  /**
   * Validate version.
   *
   * @param version the version
   * @throws ParametersException when version is null or version less than 0
   */
  public static void validateVersion(Integer version) {
    if (version == null || version < 0) {
      LOG.debug("version must be greater than 0");
      throw new ParametersException();
    }
  }
}
