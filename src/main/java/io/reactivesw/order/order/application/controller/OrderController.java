package io.reactivesw.order.order.application.controller;

import io.reactivesw.order.order.application.model.Order;
import io.reactivesw.order.order.application.model.OrderFromCartDraft;
import io.reactivesw.order.order.domain.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Davis on 17/2/6.
 */
@RestController
public class OrderController {
  /**
   * log.
   */
  private static final Logger LOG = LoggerFactory.getLogger(OrderController.class);

  /**
   * order service.
   */
  @Autowired
  private transient OrderService orderService;

  /**
   * create order from cart.
   * @param draft OrderFromCartDraft
   * @return Order
   */
  @ApiOperation("Create Order from Cart")
  @PostMapping("/orders")
  public Order createOrderFromCart(@RequestBody
                                   @ApiParam(value = "order from cart draft", required = true)
                                   @Valid OrderFromCartDraft draft) {
    LOG.debug("enter createOrderFromCart, draft is : {}", draft.toString());

    Order result = orderService.createOrderFromCart(draft);

    LOG.debug("end createOrderFromCart, result is : {}", result.toString());

    return result;
  }
}
