package io.reactivesw.project.application.controller;

import io.reactivesw.project.application.model.Currency;
import io.reactivesw.project.application.model.mapper.CurrencyMapper;
import io.reactivesw.project.domain.entity.CurrencyValue;
import io.reactivesw.project.domain.service.InternationalService;
import io.reactivesw.route.ProjectRouter;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 17/1/5.
 */
@RestController
public class InternationalController {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(InternationalController.class);

  /**
   * service
   */
  @Autowired
  private transient InternationalService service;

  /**
   * get default currency.
   * TODO change the url path.
   *
   * @return Currency default currency
   */
  @ApiOperation(value = "get default currency of this project")
  @GetMapping(value = ProjectRouter.CURRENCY_ROOT)
  public Currency getDefaultCurrency() {

    CurrencyValue currencyValue = service.getDefaultCurrency();

    LOG.debug("Default currency: {}", currencyValue);

    return CurrencyMapper.entityToModel(currencyValue);
  }

  /**
   * Create default currency currency.
   *
   * @param currency the currency
   * @return the currency
   */
  @ApiOperation(value = "create default currency of this project")
  @PostMapping(value = ProjectRouter.CURRENCY_ROOT)
  public Currency createDefaultCurrency(Currency currency) {
    LOG.debug("enter createDefaultCurrency, currency is : {}", currency.toString());

    Currency savedCurrency = service.createDefaultCurrency(currency);

    LOG.debug("end createDefaultCurrency, currency is : {}", savedCurrency.toString());

    return savedCurrency;
  }
}
