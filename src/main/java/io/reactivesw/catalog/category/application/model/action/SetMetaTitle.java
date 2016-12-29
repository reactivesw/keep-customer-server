package io.reactivesw.catalog.category.application.model.action;

import io.reactivesw.catalog.category.infrastructure.util.UpdateActionUtils;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/6.
 */
@Getter
@Setter
public class SetMetaTitle implements UpdateAction {
  /**
   * The Meta title.
   */
  private LocalizedString metaTitle;

  @Override
  public String getActionName() {
    return UpdateActionUtils.SET_META_TITLE;
  }
}
