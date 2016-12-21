package io.reactivesw.order.shippingmethod.application.controller;

import io.reactivesw.order.shippingmethod.application.model.ShippingMethod;
import io.reactivesw.order.shippingmethod.application.model.ShippingMethodDraft;
import io.reactivesw.order.shippingmethod.application.model.mapper.ShippingMethodMapper;
import io.reactivesw.order.shippingmethod.application.service.ShippingMethodApplication;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.service.ShippingMethodService;
import io.reactivesw.route.ShippingMethodRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by umasuo on 16/12/21.
 */
@RestController
public class ShippingMethodController {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ShippingMethodController.class);

  /**
   * shipping method application.
   */
  @Autowired
  private transient ShippingMethodApplication application;

  /**
   * shipping method service.
   */
  @Autowired
  private transient ShippingMethodService service;

  /**
   * get shipping method by id.
   *
   * @param id String id
   * @return ShippingMethod
   */
  @GetMapping(ShippingMethodRouter.SHIPPING_METHOD_WITH_ID)
  public ShippingMethod getById(@PathVariable String id) {
    LOG.info("enter: id: {}", id);

    ShippingMethodEntity entity = service.getById(id);

    LOG.info("exit: entity: {}", entity);
    return ShippingMethodMapper.entityToModel(entity);
  }

  /**
   * @param cartId
   * @return
   */
  @GetMapping(value = ShippingMethodRouter.SHIPPING_METHOD_BASE_URL, params = "cartId")
  public List<ShippingMethod> getForCart(@RequestParam String cartId) {
    LOG.info("enter: cartId: {}", cartId);

    List<ShippingMethodEntity> entities = application.getShippingMethodsForCart(cartId);

    LOG.info("exit: entities: {}", entities);
    return ShippingMethodMapper.listEntityToListModel(entities);
  }

  /**
   * get shipping methods for location
   *
   * @param country
   * @param state
   * @param currency
   * @return
   */
  @GetMapping(value = ShippingMethodRouter.SHIPPING_METHOD_BASE_URL, params = "country")
  public List<ShippingMethod> getForLocation(@RequestParam String country,
                                             @RequestParam(required = false) String state,
                                             @RequestParam(required = false) String currency) {
    LOG.info("enter: country: {}, state: {}, currency: {}", country, state, currency);

    List<ShippingMethodEntity> entities = null;
    if (currency == null) {
      entities = application.getByLocation(country, state);
    } else {
      entities = application.getByLocation(country, state, currency);
    }

    LOG.info("exit: entities: {}", entities);
    return ShippingMethodMapper.listEntityToListModel(entities);
  }

  /**
   * create shipping method.
   *
   * @param draft shipping method draft
   * @return shipping method
   */
  @PostMapping(ShippingMethodRouter.SHIPPING_METHOD_BASE_URL)
  public ShippingMethod createWithDraft(@RequestBody ShippingMethodDraft draft) {
    LOG.info("enter: draft: {}", draft);

    ShippingMethodEntity entity = ShippingMethodMapper.modelToEntity(draft);
    ShippingMethodEntity result = service.createShippingMethod(entity);

    LOG.info("exit: entity: {}", result);
    return ShippingMethodMapper.entityToModel(result);
  }
}
