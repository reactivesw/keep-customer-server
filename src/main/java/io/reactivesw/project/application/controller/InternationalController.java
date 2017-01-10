package io.reactivesw.project.application.controller;

import io.reactivesw.common.model.UpdateRequest;
import io.reactivesw.project.application.model.Currency;
import io.reactivesw.project.application.model.International;
import io.reactivesw.project.application.model.Language;
import io.reactivesw.project.application.model.action.InternationalUpdateAction;
import io.reactivesw.project.domain.service.InternationalService;
import io.reactivesw.route.ProjectRouter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by umasuo on 17/1/5.
 */
@RestController
public class InternationalController {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(InternationalController.class);

  /**
   * service.
   */
  @Autowired
  private transient InternationalService service;

  /**
   * Gets international.
   *
   * @return the international
   */
  @ApiOperation(value = "get international of this project")
  @GetMapping(value = ProjectRouter.INTERNATIONAL_ROOT)
  public International getInternational() {
    LOG.debug("enter getInternational");

    International international = service.getInternational();

    LOG.debug("end getInternational, reuslt is : {}", international.toString());

    return international;
  }

  /**
   * Update international international.
   *
   * @param updateRequest the update request
   * @return the international
   */
  @ApiOperation(value = "update international")
  @PutMapping(value = ProjectRouter.INTERNATIONAL_ROOT)
  public International updateInternational(@RequestBody
                                           @ApiParam(value = "International Update Fields",
                                               required = true)
                                               UpdateRequest<InternationalUpdateAction>
                                               updateRequest) {
    LOG.debug("enter updateInternational");

    International result = service.updateInternational(updateRequest.getActions());

    LOG.debug("end updateInternational, updated international is : {}", result.toString());

    return result;
  }

  /**
   * Gets default currency.
   *
   * @return the default currency
   */
  @ApiOperation(value = "get default currency")
  @GetMapping(value = ProjectRouter.DEFAULT_CURRENCY_ROOT)
  public Currency getDefaultCurrency() {
    LOG.debug("enter getDefaultCurrency");
    Currency currency = service.getInternational().getDefaultCurrency();
    LOG.debug("end getDefaultCurrency, get result is : {}", currency);
    return currency;
  }

  /**
   * Gets support currencies.
   *
   * @return the support currencies
   */
  @ApiOperation(value = "get support currencies")
  @GetMapping(value = ProjectRouter.SUPPORT_CURRENCY_ROOT)
  public List<Currency> getSupportCurrencies() {
    LOG.debug("enter getSupportCurrencies");
    List result = service.getInternational().getSupportCurrencies();
    LOG.debug("end getSupportCurrencies, get result is : {}", result);
    return result;
  }


  /**
   * Gets default language.
   *
   * @return the default language
   */
  @ApiOperation(value = "get default language")
  @GetMapping(value = ProjectRouter.DEFAULT_LANGUAGE_ROOT)
  public Language getDefaultLanguage() {
    LOG.debug("enter getDefaultLanguage");
    Language result = service.getInternational().getDefaultLanguage();
    LOG.debug("end getDefaultLanguage, get result is : {}", result);
    return result;
  }

  /**
   * Gets support languages.
   *
   * @return the support languages
   */
  @ApiOperation(value = "get support currencies")
  @GetMapping(value = ProjectRouter.SUPPORT_LANGUAGE_ROOT)
  public List<Language> getSupportLanguages() {
    LOG.debug("enter getSupportLanguages");
    List result = service.getInternational().getSupportLanguages();
    LOG.debug("end getSupportLanguages, get result is : {}", result);
    return result;
  }
}
