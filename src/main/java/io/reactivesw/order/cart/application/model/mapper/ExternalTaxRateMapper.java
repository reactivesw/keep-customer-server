package io.reactivesw.order.cart.application.model.mapper;

import io.reactivesw.catalog.taxcategory.application.model.ExternalTaxRateDraft;
import io.reactivesw.order.cart.domain.entity.value.TaxRateValue;

/**
 * Created by umasuo on 16/12/16.
 */
public class ExternalTaxRateMapper {


  /**
   * convert ExternalTaxRateDraft to TaxRateValue.
   *
   * @param draft ExternalTaxRateDraft
   * @return TaxRateValue
   */
  public static TaxRateValue draftToEntity(ExternalTaxRateDraft draft) {
    TaxRateValue taxRate = new TaxRateValue();
    taxRate.setIncludedInPrice(Boolean.FALSE);
    taxRate.setName(draft.getName());
    taxRate.setAmount(draft.getAmount());
    taxRate.setCountry(draft.getCountry());
    taxRate.setState(draft.getState());
//TODO    taxRate.setSubRates(SubRateMapper.modelListToEntitySet(draft.getSubRates()));
    return taxRate;
  }
}
