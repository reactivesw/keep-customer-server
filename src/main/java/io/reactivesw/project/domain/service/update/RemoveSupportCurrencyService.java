package io.reactivesw.project.domain.service.update;

import io.reactivesw.common.exception.ParametersException;
import io.reactivesw.common.model.Update;
import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.project.application.model.action.RemoveSupportCurrencyAction;
import io.reactivesw.project.domain.entity.CurrencyValue;
import io.reactivesw.project.domain.entity.InternationalEntity;
import io.reactivesw.project.infrastructure.util.InternationalActionUtils;
import io.reactivesw.project.infrastructure.validator.CurrencyValidator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by Davis on 17/1/9.
 */
@Service(value = InternationalActionUtils.REMOVE_SUPPORT_CURRENCY)
public class RemoveSupportCurrencyService implements Update<InternationalEntity> {

  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(RemoveSupportCurrencyService.class);

  /**
   * add support currency.
   *
   * @param entity E
   * @param action UpdateAction
   */
  @Override
  public void handle(InternationalEntity entity, UpdateAction action) {

    String currencyCode = ((RemoveSupportCurrencyAction) action).getCurrencyCode();

    CurrencyValidator.validate(currencyCode);

    if (entity.getDefaultCurrency().getCurrencyCode().equals(currencyCode)) {
      LOG.debug("can not remove support currency which is default currency, code is : {}",
          currencyCode);
      throw new ParametersException("Can not remove support currency which is default currency.");
    }

    Set<CurrencyValue> supportCurrencies = entity.getSupportedCurrency();

    Predicate<CurrencyValue> predicate = currencyValue -> currencyValue
        .getCurrencyCode().equals(currencyCode);

    supportCurrencies.removeIf(predicate);

    entity.setSupportedCurrency(supportCurrencies);
  }
}
