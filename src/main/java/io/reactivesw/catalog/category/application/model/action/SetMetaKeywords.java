package io.reactivesw.catalog.category.application.model.action;

import io.reactivesw.catalog.category.infrastructure.util.CategoryActionUtils;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.common.model.LocalizedString;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/6.
 */
@Getter
@Setter
public class SetMetaKeywords implements UpdateAction {
  /**
   * The Meta keywords.
   */
  private LocalizedString metaKeywords;

  @Override
  public String getActionName() {
    return CategoryActionUtils.SET_META_KEYWORD;
  }
}
