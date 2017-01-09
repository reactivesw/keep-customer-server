package io.reactivesw.common.model;

import io.reactivesw.catalog.category.application.model.action.CategoryUpdateAction;
import io.reactivesw.catalog.inventory.application.model.action.InventoryEntryUpdateAction;
import io.reactivesw.catalog.producttype.application.model.action.ProductTypeUpdateAction;
import io.reactivesw.order.cart.application.model.action.CartUpdateAction;
import io.reactivesw.order.cartdiscount.application.model.action.CartDiscountUpdateAction;
import io.reactivesw.order.discountcode.application.model.action.DiscountCodeUpdateAction;
import io.reactivesw.order.shippingmethod.application.model.action.ShippingMethodUpdateAction;
import io.reactivesw.order.zone.application.model.action.ZoneUpdateAction;
import io.reactivesw.project.application.model.action.InternationalUpdateAction;

/**
 * configurations for common update actions that will be used in more thant one service
 * and this action also extends other action configure in each service.
 * Created by umasuo on 16/11/21.
 */
public interface UpdateAction
    extends
    CartDiscountUpdateAction,
    CartUpdateAction,
    DiscountCodeUpdateAction,
    ShippingMethodUpdateAction,
    ZoneUpdateAction,
    CategoryUpdateAction,
    InventoryEntryUpdateAction,
    ProductTypeUpdateAction,
    InternationalUpdateAction {
  String getActionName();
}
