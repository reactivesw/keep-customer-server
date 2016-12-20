package io.reactivesw.catalog.taxcategory.application.model.mapper;

import io.reactivesw.catalog.taxcategory.application.model.action.AddTaxRate;
import io.reactivesw.catalog.taxcategory.application.model.action.RemoveTaxRate;
import io.reactivesw.catalog.taxcategory.application.model.action.ReplaceTaxRate;
import io.reactivesw.common.model.action.SetDescription;
import io.reactivesw.common.model.action.SetName;
import io.reactivesw.common.model.Update;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * Created by Davis on 16/12/11.
 */
public interface TaxCategoryUpdateMapper<E> extends Update<E> {
  /**
   * ImmutableMap for discount code update mapper.
   */
  Map<Class<?>, TaxCategoryUpdateMapper> updateMappers = ImmutableMap.<Class<?>,
      TaxCategoryUpdateMapper>builder()
      .put(SetName.class, new SetNameMapper())
      .put(SetDescription.class, new SetDescriptionMapper())
      .put(AddTaxRate.class, new AddTaxRateMapper())
      .put(ReplaceTaxRate.class, new ReplaceTaxRateMapper())
      .put(RemoveTaxRate.class, new ReplaceTaxRateMapper())
      .build();

  /**
   * @param clazz
   * @return
   */
  static TaxCategoryUpdateMapper getMapper(Class<?> clazz) {
    return updateMappers.get(clazz);
  }
}
