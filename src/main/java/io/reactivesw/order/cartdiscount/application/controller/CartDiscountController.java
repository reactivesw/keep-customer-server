package io.reactivesw.order.cartdiscount.application.controller;

import io.reactivesw.common.model.UpdateRequest;
import io.reactivesw.order.cartdiscount.application.model.CartDiscount;
import io.reactivesw.order.cartdiscount.application.model.CartDiscountDraft;
import io.reactivesw.order.cartdiscount.application.model.mapper.CartDiscountMapper;
import io.reactivesw.order.cartdiscount.application.service.CartDiscountApplication;
import io.reactivesw.order.cartdiscount.domain.service.CartDiscountService;
import io.reactivesw.route.CartDiscountRouter;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
   * cart discount service.
   */
  @Autowired
  private transient CartDiscountService service;

  /**
   * cart discount application.
   */
  @Autowired
  private transient CartDiscountApplication application;

  /**
   * get cart discount by id.
   *
   * @param id String
   */
  @ApiOperation("get cart discount by id")
  @GetMapping(CartDiscountRouter.CART_DISCOUNT_WITH_ID)
  public CartDiscount getById(@PathVariable @ApiParam(required = true) String id) {
    LOG.info("enter: id: {}", id);

    CartDiscount value = application.getById(id);

    LOG.info("exit: value: {}", value);
    return value;
  }

  /**
   * create new cart discount.
   *
   * @param draft CartDiscountDraft
   * @return CartDiscount
   */
  @ApiOperation("create cart discount with draft")
  @PostMapping(CartDiscountRouter.CART_DISCOUNT_ROOT)
  public CartDiscount create(@RequestBody @ApiParam(required = true) CartDiscountDraft draft) {
    LOG.info("enter: draft: {}", draft);

    CartDiscount value = application.createCartDiscount(CartDiscountMapper.modelToEntity(draft));

    LOG.info("exit: value: {}", value);
    return value;
  }

  /**
   * update cart discount.
   *
   * @param id            cart discount id
   * @param updateRequest update request
   * @return updated cart discount
   */
  @ApiOperation("Update cart discount with id")
  @PutMapping(CartDiscountRouter.CART_DISCOUNT_WITH_ID)
  public CartDiscount update(
      @PathVariable @ApiParam(required = true) String id,
      @RequestBody @ApiParam(required = true) UpdateRequest
          updateRequest) {
    LOG.info("enter: id: {}, UpdateRequest: {}", id, updateRequest);

    CartDiscount value = application.update(id, updateRequest.getVersion(), updateRequest
        .getActions());

    LOG.info("exit: value: {}", value);
    return value;
  }

  /**
   * delete a cart discount.
   *
   * @param id      String
   * @param version Integer
   */
  @ApiOperation("delete cart discount with id & version")
  @DeleteMapping(CartDiscountRouter.CART_DISCOUNT_WITH_ID)
  public void delete(@PathVariable @ApiParam(required = true) String id,
                     @RequestParam @ApiParam(required = true) Integer version) {
    LOG.info("enter: id: {}, version: {}", id, version);

    service.deleteById(id, version);
  }

}
