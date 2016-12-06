package io.reactivesw.orders.carts.applications.controllers;

import io.reactivesw.common.models.UpdateRequest;
import io.reactivesw.orders.carts.applications.models.Cart;
import io.reactivesw.orders.carts.applications.models.mapper.CartMapper;
import io.reactivesw.orders.carts.domains.entities.CartEntity;
import io.reactivesw.orders.carts.domains.services.CartService;
import io.reactivesw.routes.Router;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 16/11/21.
 */
@RestController
public class CartController {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartController.class);

  /**
   * cart service.
   */
  @Autowired
  private transient CartService cartService;

  /**
   * get cart by id.
   *
   * @param id the id
   * @return the cart by id
   */
  @ApiOperation(value = "Get cart by cart id.")
  @GetMapping(Router.CART_WITH_ID)
  public Cart getCartById(@ApiParam(required = true) @PathVariable(Router.CART_ID) String id) {

    CartEntity entity = this.cartService.getCartByCartId(id);

    return CartMapper.convertEntityToModel(entity);
  }

  /**
   * get cart by customer id.
   *
   * @param customerId the customer id
   * @return the cart by customer id
   */
  @ApiOperation(value = "get carts by customer id")
  @GetMapping(value = Router.CARTS_ROOT, params = "customerId")
  public Cart getCartByCustomerId(@ApiParam(value = "customerId", required = false)
                                      String customerId) {
    return null;
  }

  /**
   * update cart with cart id.
   *
   * @param id String
   * @return Cart
   */
  @PutMapping(Router.CART_WITH_ID)
  public Cart updateCart(@ApiParam(required = true) @PathVariable(Router.CART_ID) String id,
                         @RequestBody UpdateRequest updateRequest) {
    LOG.info("id:{}", id);
    return null;
  }

  /**
   * Sets cart service.
   *
   * @param cartService the cart service
   */
  protected void setCartService(CartService cartService) {
    this.cartService = cartService;
  }
}
