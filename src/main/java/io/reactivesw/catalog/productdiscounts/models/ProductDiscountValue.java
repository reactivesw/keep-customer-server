package io.reactivesw.catalog.productdiscounts.models;

import io.reactivesw.common.models.Money;

import java.util.Collections;
import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public interface ProductDiscountValue {
  static AbsoluteProductDiscountValue ofAbsolute(final List<Money> money) {
    return AbsoluteProductDiscountValue.of(money);
  }

  static AbsoluteProductDiscountValue ofAbsolute(final Money money) {
    return AbsoluteProductDiscountValue.of(Collections.singletonList(money));
  }

  static RelativeProductDiscountValue ofRelative(final int permyriad) {
    return RelativeProductDiscountValue.of(permyriad);
  }
}
