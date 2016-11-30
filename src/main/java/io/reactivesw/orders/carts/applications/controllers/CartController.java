package io.reactivesw.orders.carts.applications.controllers;

import io.reactivesw.orders.carts.applications.models.Cart;
import io.reactivesw.routes.Router;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 16/11/21.
 */
@RestController
public class CartController {


  /**
   * get cart by id.
   */
  @GetMapping(Router.CART_GET_BY_ID)
  public Cart getCartById(@ApiParam(required = true) @PathVariable(Router.CART_ID) String id) {
    return null;
  }

  /**
   * get cart by customer id.
   */
  @ApiOperation(value = "get carts by customer id")
  @GetMapping(value = Router.CARTS_ROOT, params = "customerId")
  public Cart getCartByCustomerId(@ApiParam(value = "customerId", required = false)
                                      String customerId) {
    return null;
  }
}
