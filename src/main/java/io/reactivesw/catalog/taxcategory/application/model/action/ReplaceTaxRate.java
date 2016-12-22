package io.reactivesw.catalog.taxcategory.application.model.action;

import io.reactivesw.catalog.taxcategory.application.model.TaxRateDraft;
import io.reactivesw.common.model.UpdateAction;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/11.
 */
@Getter
@Setter
public class ReplaceTaxRate implements UpdateAction {
  /**
   * The Tax rate id.
   */
  private String taxRateId;

  /**
   * The Tax rate.
   */
  private TaxRateDraft taxRate;
}
