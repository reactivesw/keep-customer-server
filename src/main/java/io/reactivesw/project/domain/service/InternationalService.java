package io.reactivesw.project.domain.service;

import com.google.common.collect.Sets;

import io.reactivesw.common.exception.AlreadyExistException;
import io.reactivesw.common.exception.NotExistException;
import io.reactivesw.project.application.model.Currency;
import io.reactivesw.project.application.model.International;
import io.reactivesw.project.application.model.mapper.CurrencyMapper;
import io.reactivesw.project.application.model.mapper.InternationalMapper;
import io.reactivesw.project.domain.entity.CurrencyValue;
import io.reactivesw.project.domain.entity.InternationalEntity;
import io.reactivesw.project.infrastructure.repository.InternationalRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by umasuo on 17/1/5.
 */
@Service
public class InternationalService {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(InternationalService.class);

  /**
   * repository.
   */
  private transient InternationalRepository repository;

  /**
   * get system default currency.
   *
   * @return Currency Value
   */
  public CurrencyValue getDefaultCurrency() {
    InternationalEntity international = getInternationalEntity();

    CurrencyValue defaultCurrency = international.getDefaultCurrency();

    LOG.debug("DefaultCurrency: {}", defaultCurrency);
    return defaultCurrency;
  }


  /**
   * Create default currency currency.
   *
   * @param currency the currency
   * @return the currency
   */
  public Currency createDefaultCurrency(Currency currency) {
    LOG.debug("enter createDefaultCurrency, currency: {}", currency.toString());

    List<InternationalEntity> internationals = repository.findAll();
    if (internationals != null && !internationals.isEmpty()) {
      LOG.debug("default currency has setted, can not create");
      throw new AlreadyExistException("default currency already exist");
    }

    InternationalEntity defaultInternational = InternationalMapper.modelToEntity(currency);

    InternationalEntity savedInternationalEntity = repository.save(defaultInternational);

    Currency defaultCurrency = CurrencyMapper.entityToModel(
        savedInternationalEntity.getDefaultCurrency());

    LOG.debug("end createDefaultCurrency, created currency is : {}", defaultCurrency.toString());

    return defaultCurrency;
  }

  /**
   * Add currency currency.
   *
   * @param currency the currency
   * @return the currency
   */
  public International addCurrency(Currency currency) {
    LOG.debug("enter addCurrency, currency is : {}", currency.toString());

    InternationalEntity internationalEntity = getInternationalEntity();

    Set<CurrencyValue> currencyValues = Sets.newHashSet(internationalEntity.getDefaultCurrency());
    currencyValues.add(CurrencyMapper.modelToEntity(currency));
    internationalEntity.setSupportedCurrency(currencyValues);

    InternationalEntity savedInternational = repository.save(internationalEntity);

    International result = InternationalMapper.entityToModel(savedInternational);

    LOG.debug("end addCurrency, currency is : {}", result.toString());

    return result;
  }

  /**
   * get international entity.
   *
   * @return InternationalEntity
   */
  private InternationalEntity getInternationalEntity() {
    List<InternationalEntity> internationals = repository.findAll();

    if (internationals == null || internationals.isEmpty()) {
      LOG.debug("should set default currency");
      throw new NotExistException("International is not exist");
    }

    return internationals.parallelStream().findAny().get();
  }
}
