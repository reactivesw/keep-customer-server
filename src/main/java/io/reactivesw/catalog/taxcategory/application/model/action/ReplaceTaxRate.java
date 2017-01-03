package io.reactivesw.catalog.taxcategory.application.model.action;

import io.reactivesw.catalog.taxcategory.application.model.TaxRateDraft;
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
public class ReplaceTaxRate implements UpdateAction {
  /**
   * The Tax rate id.
   */
  @NotNull
  @Size(min = 1)
  private String taxRateId;

  /**
   * The Tax rate.
   */
  @NotNull
  private TaxRateDraft taxRate;

  @Override
  public String getActionName() {
    return TaxCategoryActionUtils.REPLACE_TAX_RATE;
  }
}
