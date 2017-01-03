package io.reactivesw.catalog.taxcategory.domain.service.update;

import io.reactivesw.catalog.taxcategory.application.model.action.RemoveTaxRate;
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
@Service(value = TaxCategoryActionUtils.REMOVE_TAX_RATE)
public class RemoveTaxRateService implements Update<TaxCategoryEntity> {

  /**
   * remove tax rate.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(TaxCategoryEntity entity, UpdateAction action) {
    RemoveTaxRate removeTaxRate = (RemoveTaxRate) action;
    String taxRateId = removeTaxRate.getTaxRateId();

    Set<TaxRateEntity> taxRateEntities = entity.getRates().stream().filter(
        rate -> !Objects.equals(rate.getId(), taxRateId)
    ).collect(Collectors.toSet());

    entity.setRates(taxRateEntities);
  }
}
