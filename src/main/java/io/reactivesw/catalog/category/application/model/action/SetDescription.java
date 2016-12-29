package io.reactivesw.catalog.category.application.model.action;

import io.reactivesw.common.model.LocalizedString;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/29.
 */
@Getter
@Setter
public class SetDescription implements UpdateAction {
  /**
   * If the description parameter is not included, the field will be emptied.
   */
  private LocalizedString description;

  @Override
  public String getActionName() {
    return null;
  }
}