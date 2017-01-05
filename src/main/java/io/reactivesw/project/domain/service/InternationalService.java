package io.reactivesw.project.domain.service;

import io.reactivesw.project.domain.entity.CurrencyValue;
import io.reactivesw.project.domain.entity.InternationalEntity;
import io.reactivesw.project.infrastructure.repository.InternationalRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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
    List<InternationalEntity> internationals = repository.findAll();
    InternationalEntity international = internationals.parallelStream().findAny().orElse(null);

    CurrencyValue defaultCurrency = international.getDefaultCurrency();
    if (defaultCurrency == null) {
      defaultCurrency = this.createDefaultCurrency(international);
    }

    LOG.debug("DefaultCurrency: {}", defaultCurrency);
    return defaultCurrency;
  }

  /**
   * create default currency.
   * TODO this should set by the ADMIN.
   *
   * @param international
   * @return CurrencyValue
   */
  private CurrencyValue createDefaultCurrency(InternationalEntity international) {
    LOG.debug("enter: international: {}", international);
    
    CurrencyValue defaultCurrency = new CurrencyValue();
    defaultCurrency.setCurrencyCode("USD");
    defaultCurrency.setName("US Dollar");
    international.setDefaultCurrency(defaultCurrency);
    repository.save(international);

    LOG.debug("exit: international: {}", international);
    return defaultCurrency;
  }
}
