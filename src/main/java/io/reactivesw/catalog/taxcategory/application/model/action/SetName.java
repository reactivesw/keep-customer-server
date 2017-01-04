package io.reactivesw.catalog.taxcategory.application.model.action;

import io.reactivesw.catalog.taxcategory.infrastructure.util.TaxCategoryActionUtils;
import io.reactivesw.common.model.UpdateAction;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 17/1/3.
 */
@Getter
@Setter
public class SetName implements UpdateAction {

  /**
   * The Name.
   */
  @NotNull
  @Size(min = 1)
  private String name;

  @Override
  public String getActionName() {
    return TaxCategoryActionUtils.SET_NAME;
  }
}
