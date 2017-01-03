package io.reactivesw.catalog.taxcategory.domain.service.update;

import com.google.common.collect.Sets;
import io.reactivesw.catalog.taxcategory.application.model.TaxRateDraft;
import io.reactivesw.catalog.taxcategory.application.model.action.AddTaxRate;
import io.reactivesw.catalog.taxcategory.application.model.mapper.TaxRateMapper;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxRateEntity;
import io.reactivesw.catalog.taxcategory.infrastructure.util.TaxCategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Davis on 16/12/11.
 */
@Service(value = TaxCategoryActionUtils.ADD_TAX_RATE)
public class AddTaxRateService implements Update<TaxCategoryEntity> {

  /**
   * add tax rate.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(TaxCategoryEntity entity, UpdateAction action) {
    AddTaxRate addTaxRate = (AddTaxRate) action;

    TaxRateDraft taxRateDraft = addTaxRate.getTaxRate();
    TaxRateEntity taxRateEntity = TaxRateMapper.modelToEntity(taxRateDraft);

    Set<TaxRateEntity> rates = Sets.newHashSet(taxRateEntity);
    rates.addAll(entity.getRates());

    entity.setRates(rates);
  }
}
