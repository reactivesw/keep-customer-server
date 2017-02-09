package io.reactivesw.order.order.application.controller;

import static io.reactivesw.route.OrderRouter.ORDER_ID;
import static io.reactivesw.route.OrderRouter.ORDER_ROOT;
import static io.reactivesw.route.OrderRouter.ORDER_WITH_ID;

import io.reactivesw.order.order.application.model.Order;
import io.reactivesw.order.order.application.model.OrderFromCartDraft;
import io.reactivesw.order.order.domain.service.OrderService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
   *
   * @param draft OrderFromCartDraft
   * @return Order order
   */
  @ApiOperation("Create Order from Cart")
  @PostMapping(ORDER_ROOT)
  public Order createOrderFromCart(@RequestBody
                                   @ApiParam(value = "order from cart draft", required = true)
                                   @Valid OrderFromCartDraft draft) {
    LOG.debug("enter createOrderFromCart, draft is : {}", draft.toString());

    Order result = orderService.createOrderFromCart(draft);

    LOG.debug("end createOrderFromCart, result is : {}", result.toString());

    return result;
  }


  /**
   * Gets order by id.
   *
   * @param orderId the order id
   * @return the order by id
   */
  @ApiOperation("get order by id")
  @GetMapping(ORDER_WITH_ID)
  public Order getOrderById(@PathVariable(ORDER_ID)
                            @ApiParam(value = "order id", required = true)
                                String orderId) {
    LOG.debug("enter getOrderById, order id is : {}", orderId);

    Order result = orderService.getOrderById(orderId);

    LOG.debug("end getOrderById, result is : {}", result);

    return result;
  }

  /**
   * Delete order.
   *
   * @param orderId the order id
   * @param version the order version
   */
  @ApiOperation("delete order")
  @DeleteMapping(ORDER_WITH_ID)
  public void deleteOrder(@PathVariable(ORDER_ID)
                          @ApiParam(value = "order id", required = true)
                              String orderId,
                          @RequestParam
                          @ApiParam(value = "order version", required = true)
                              Integer version) {
    LOG.debug("enter deleteOrder, order id is : {}", orderId);

    orderService.deleteOrder(orderId, version);

    LOG.debug("end deleteOrder");
  }
}
