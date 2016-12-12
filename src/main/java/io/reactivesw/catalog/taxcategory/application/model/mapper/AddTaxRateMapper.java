package io.reactivesw.catalog.taxcategory.application.model.mapper;

import com.google.common.collect.Sets;
import io.reactivesw.catalog.taxcategory.application.model.TaxRateDraft;
import io.reactivesw.catalog.taxcategory.application.model.action.AddTaxRate;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxRateEntity;
import io.reactivesw.common.model.UpdateAction;

import java.util.Set;

/**
 * Created by Davis on 16/12/11.
 */
public class AddTaxRateMapper implements TaxCategoryUpdateMapper<TaxCategoryEntity> {

  @Override
  public void setAction(TaxCategoryEntity entity, UpdateAction action) {
    AddTaxRate addTaxRate = (AddTaxRate) action;

    TaxRateDraft taxRateDraft = addTaxRate.getTaxRate();
    TaxRateEntity taxRateEntity = TaxRateMapper.modelToEntity(taxRateDraft);

    Set<TaxRateEntity> rates = Sets.newHashSet(taxRateEntity);
    rates.addAll(entity.getRates());

    entity.setRates(rates);
  }
}
