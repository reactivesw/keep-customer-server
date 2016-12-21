package io.reactivesw.order.shippingmethod.application.controller;

import io.reactivesw.order.shippingmethod.application.model.ShippingMethod;
import io.reactivesw.order.shippingmethod.application.model.mapper.ShippingMethodMapper;
import io.reactivesw.order.shippingmethod.application.service.ShippingMethodApplication;
import io.reactivesw.order.shippingmethod.domain.entity.ShippingMethodEntity;
import io.reactivesw.order.shippingmethod.domain.service.ShippingMethodService;
import io.reactivesw.route.ShippingMethodRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by umasuo on 16/12/21.
 */
@RestController
public class ShippingMethodController {

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

    ShippingMethodEntity entity = service.getById(id);

    return ShippingMethodMapper.entityToModel(entity);
  }

  /**
   * @param cartId
   * @return
   */
  @GetMapping(ShippingMethodRouter.SHIPPING_METHOD_BASE_URL)
  public List<ShippingMethod> getShippingMethodForCart(@RequestParam String cartId) {

    List<ShippingMethodEntity> result = application.getShippingMethodsForCart(cartId);

    return result.parallelStream().map(
        shippingMethodEntity -> ShippingMethodMapper.entityToModel(shippingMethodEntity)
    ).collect(Collectors.toList());
  }
}
