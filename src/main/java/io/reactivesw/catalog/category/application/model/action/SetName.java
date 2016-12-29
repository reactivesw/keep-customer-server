package io.reactivesw.catalog.category.application.model.action;

import io.reactivesw.catalog.category.infrastructure.util.CategoryActionUtils;
import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/29.
 */
@Getter
@Setter
public class SetName implements UpdateAction {
  /**
   * name.
   */
  private LocalizedString name;

  @Override
  public String getActionName() {
    return CategoryActionUtils.SET_NAME;
  }
}