package io.reactivesw.catalog.taxcategory.application.model.mapper;

import io.reactivesw.catalog.taxcategory.application.model.TaxRateDraft;
import io.reactivesw.catalog.taxcategory.application.model.action.ReplaceTaxRate;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxCategoryEntity;
import io.reactivesw.catalog.taxcategory.domain.entity.TaxRateEntity;
import io.reactivesw.common.model.UpdateAction;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Davis on 16/12/11.
 */
public class ReplaceTaxRateMapper implements TaxCategoryUpdateMapper<TaxCategoryEntity> {

  @Override
  public void setAction(TaxCategoryEntity entity, UpdateAction action) {
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