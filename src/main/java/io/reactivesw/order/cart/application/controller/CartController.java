package io.reactivesw.order.cart.application.controller;

import io.reactivesw.common.model.UpdateRequest;
import io.reactivesw.order.cart.application.model.Cart;
import io.reactivesw.order.cart.application.model.action.CartUpdateAction;
import io.reactivesw.order.cart.application.service.CartApplication;
import io.reactivesw.order.cart.domain.entity.CartEntity;
import io.reactivesw.order.cart.domain.service.CartService;
import io.reactivesw.route.CartRouter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
   * cart application.
   */
  @Autowired
  private transient CartApplication cartApplication;

  /**
   * get cart by id.
   *
   * @param id the id
   * @return the cart by id
   */
  @ApiOperation(value = "Get cart by cart id.")
  @GetMapping(CartRouter.CART_WITH_ID)
  public Cart getCartById(@ApiParam(required = true) @PathVariable(CartRouter.CART_ID) String id) {
    LOG.info("cartId:{}", id);

    CartEntity entity = this.cartService.getById(id);

    LOG.info("entity:{}", entity);
    return this.cartApplication.getFullCart(entity);
  }

  /**
   * get cart by customer id.
   *
   * @param customerId the customer id
   * @return the cart by customer id
   */
  @ApiOperation(value = "get cart by customer id")
  @GetMapping(value = CartRouter.CARTS_ROOT, params = "customerId")
  public Cart getActiveCartByCustomerId(@ApiParam(value = "customerId") @RequestParam String
                                            customerId) {
    LOG.info("customerId:{}", customerId);

    CartEntity entity = this.cartService.getActiveCartByCustomerId(customerId);

    LOG.info("entity:{}", entity);
    return this.cartApplication.getFullCart(entity);
  }

  /**
   * get cart by customer id.
   *
   * @param anonymousId the customer id
   * @return the cart by customer id
   */
  @ApiOperation(value = "get cart by anonymous id")
  @GetMapping(value = CartRouter.CARTS_ROOT, params = "anonymousId")
  public Cart getCartByAnonymousId(@ApiParam(value = "anonymousId") @RequestParam String
                                       anonymousId) {
    LOG.info("anonymousId:{}", anonymousId);

    CartEntity entity = this.cartService.getCartByAnonymousId(anonymousId);

    LOG.info("entity:{}", entity);
    return this.cartApplication.getFullCart(entity);
  }

  /**
   * update cart with cart id.
   *
   * @param id String
   * @return Cart
   */
  @PutMapping(CartRouter.CART_WITH_ID)
  public Cart updateCart(@ApiParam(required = true) @PathVariable(CartRouter.CART_ID) String id,
                         @RequestBody UpdateRequest<CartUpdateAction> updateRequest) {
    LOG.info("id:{}, updateRequest: {}", id, updateRequest);

    Cart result = this.cartApplication.updateCart(id, updateRequest.getVersion(), updateRequest
        .getActions());

    LOG.info("result:{}", result);
    return result;
  }

}
