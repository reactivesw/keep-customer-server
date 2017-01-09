package io.reactivesw.project.domain.service.update;

import com.google.common.collect.Sets;

import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.project.application.model.action.SetDefaultCurrencyAction;
import io.reactivesw.project.application.model.mapper.CurrencyMapper;
import io.reactivesw.project.domain.entity.CurrencyValue;
import io.reactivesw.project.domain.entity.InternationalEntity;
import io.reactivesw.project.infrastructure.util.CurrencyMap;
import io.reactivesw.project.infrastructure.util.InternationalActionUtils;
import io.reactivesw.project.infrastructure.validator.CurrencyValidator;

import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Davis on 17/1/9.
 */
@Service(value = InternationalActionUtils.SET_DEFAULT_CURRENCY)
public class SetDefaultCurrencyService implements Update<InternationalEntity>{
  /**
   * set default currency.
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InternationalEntity entity, UpdateAction action) {

    String currencyCode = ((SetDefaultCurrencyAction) action).getCurrencyCode();

    CurrencyValidator.validate(currencyCode);

    CurrencyValue currencyValue = CurrencyMapper.modelToEntity(
        CurrencyMap.getCurrencyByCode(currencyCode));

    CurrencyValue defaultCurrency = entity.getDefaultCurrency();

    Set<CurrencyValue> currencyValues = entity.getSupportedCurrency();

    if (currencyValues.isEmpty()) {
      entity.setDefaultCurrency(currencyValue);
      currencyValues = Sets.newHashSet(currencyValue);
      entity.setSupportedCurrency(currencyValues);
    } else {
      entity.setDefaultCurrency(currencyValue);
      currencyValues.remove(defaultCurrency);
      currencyValues.add(currencyValue);
      entity.setSupportedCurrency(currencyValues);
    }
  }
}
