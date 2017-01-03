package io.reactivesw.catalog.taxcategory.domain.service.update;

import io.reactivesw.catalog.taxcategory.application.model.TaxRateDraft;
import io.reactivesw.catalog.taxcategory.application.model.action.ReplaceTaxRate;
import io.reactivesw.catalog.taxcategory.application.model.mapper.TaxRateMapper;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxRateEntity;
import io.reactivesw.catalog.taxcategory.infrastructure.util.TaxCategoryActionUtils;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;

import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/11.
 */
@Service(value = TaxCategoryActionUtils.REPLACE_TAX_RATE)
public class ReplaceTaxRateService implements Update<TaxCategoryEntity> {

  /**
   * replace tax rate.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(TaxCategoryEntity entity, UpdateAction action) {
    ReplaceTaxRate replaceTaxRate = (ReplaceTaxRate) action;

    String taxRateId = replaceTaxRate.getTaxRateId();
    TaxRateDraft taxRateDraft = replaceTaxRate.getTaxRate();

    //get TaxRate
    Set<TaxRateEntity> taxRates = entity.getRates().stream().map(
        rate -> {
          if (Objects.equals(rate.getId(), taxRateId)) {
            rate = TaxRateMapper.modelToEntity(taxRateDraft, rate);
          }
          return rate;
        }
    ).collect(Collectors.toSet());

    entity.setRates(taxRates);
  }
}