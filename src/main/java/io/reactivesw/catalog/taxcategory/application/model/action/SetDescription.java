package io.reactivesw.catalog.taxcategory.application.model.action;

import io.reactivesw.catalog.taxcategory.infrastructure.util.TaxCategoryActionUtils;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 17/1/3.
 */
@Getter
@Setter
public class SetDescription implements UpdateAction {
  /**
   * The Description.
   */
  private String description;

  @Override
  public String getActionName() {
    return TaxCategoryActionUtils.SET_DESCRIPTION;
  }
}
