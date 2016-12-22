package io.reactivesw.order.cartdiscount.application.controller;

import io.reactivesw.order.cartdiscount.application.model.CartDiscount;
import io.reactivesw.route.CartDiscountRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 16/12/21.
 */
@RestController
public class CartDiscountController {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartDiscountController.class);

  /**
   * get cart discount by id.
   *
   * @param id String
   */
  @PutMapping(CartDiscountRouter.CART_DISCOUNT_WITH_ID)
  public CartDiscount getById(@PathVariable String id) {
    LOG.info("enter: id: {}", id);
    return null;
  }
}
