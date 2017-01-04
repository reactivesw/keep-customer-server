package io.reactivesw.catalog.taxcategory.application.model.action;

import io.reactivesw.catalog.taxcategory.application.model.TaxRateDraft;
import io.reactivesw.catalog.taxcategory.infrastructure.util.TaxCategoryActionUtils;
import io.reactivesw.common.model.UpdateAction;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * Created by Davis on 16/12/11.
 */
@Getter
@Setter
public class AddTaxRate implements UpdateAction {
  /**
   * The Tax rate.
   */
  @NotNull
  private TaxRateDraft taxRate;

  @Override
  public String getActionName() {
    return TaxCategoryActionUtils.ADD_TAX_RATE;
  }
}
