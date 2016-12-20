package io.reactivesw.order.cart.domain.service.update;

import io.reactivesw.common.model.UpdateAction;
import io.reactivesw.order.cart.application.model.action.AddDiscountCode;
import io.reactivesw.order.cart.domain.entity.CartEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Adds a DiscountCode to the cart to enable the related CartDiscounts.
 * Created by umasuo on 16/12/19.
 */
public class AddDiscountCodeService extends CartUpdateService {


  /**
   * add discount code service.
   *
   * @param cart   CartEntity
   * @param action UpdateAction
   */
  @Override
  public void handle(CartEntity cart, UpdateAction action) {
    AddDiscountCode addDiscountCode = (AddDiscountCode) action;

    String code = addDiscountCode.getCode();

    List<String> codes = cart.getDiscountCodes();

    if (codes == null) {
      codes = new ArrayList<>();
    }

    if (!codes.contains(code)) {
      codes.add(code);
    }

    cart.setDiscountCodes(codes);
  }
}
