package io.reactivesw.catalog.category.infrastructure.validator;

import io.reactivesw.catalog.category.application.model.CategoryDraft;
import io.reactivesw.catalog.category.domain.entity.CategoryEntity;
import io.reactivesw.catalog.category.infrastructure.util.CategoryUtils;
import io.reactivesw.common.entity.LocalizedStringEntity;
import io.reactivesw.common.exception.AlreadyExistException;
import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.LocalizedString;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by Davis on 16/12/6.
 */
public final class CategoryNameValidator {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CategoryNameValidator.class);

  /**
   * Instantiates a new Category validator.
   */
  private CategoryNameValidator() {
  }

  /**
   * Validate null.
   *
   * @param draft the draft
   */
  public static void validateNull(CategoryDraft draft) {

    if (draft.getName() == null
        || draft.getName().getLocalized() == null
        || draft.getName().getLocalized().isEmpty()) {
      LOG.debug("Category name can not be null");
      throw new ParametersException("Category name can not be null");
    }
  }

  /**
   * Equal validate.
   *
   * @param name               the name
   * @param sameRootCategories the same root categories
   */
  public static void validateEqual(LocalizedString name, List<CategoryEntity> sameRootCategories) {
    List<LocalizedStringEntity> categoryNames =
        CategoryUtils.getAllCategoryNames(sameRootCategories);
    Map<String, String> localizedName = name.getLocalized();
    for (Map.Entry entry : localizedName.entrySet()) {
      String key = entry.getKey().toString();
      String value = entry.getValue().toString();
      for (LocalizedStringEntity categoryName : categoryNames) {
        if (key.equals(categoryName.getLanguage()) && value.equals(categoryName.getText())) {
          LOG.debug("can not create category with same name : {}, key: {}", value, key);
          throw new AlreadyExistException("Can not create category with same name");
        }
      }
    }
  }
}
