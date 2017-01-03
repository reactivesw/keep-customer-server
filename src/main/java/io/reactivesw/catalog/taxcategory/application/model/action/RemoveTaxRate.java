package io.reactivesw.catalog.taxcategory.application.model.action;

import io.reactivesw.catalog.taxcategory.infrastructure.util.TaxCategoryActionUtils;
import io.reactivesw.common.model.UpdateAction;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/12/11.
 */
@Getter
@Setter
public class RemoveTaxRate implements UpdateAction {
  /**
   * The Tax rate id.
   */
  @NotNull
  @Size(min = 1)
  private String taxRateId;

  @Override
  public String getActionName() {
    return TaxCategoryActionUtils.REMOVE_TAX_RATE;
  }
}
