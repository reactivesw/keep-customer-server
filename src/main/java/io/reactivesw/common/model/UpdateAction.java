package io.reactivesw.common.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.reactivesw.common.model.action.SetDescription;
import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.action.SetLocalizedName;
import io.reactivesw.common.model.action.SetName;
import io.reactivesw.order.cart.application.model.action.CartUpdateAction;
import io.reactivesw.order.cartdiscount.application.model.action.CartDiscountUpdateAction;
import io.reactivesw.order.discountcode.application.model.action.DiscountCodeUpdateAction;
import io.reactivesw.order.shippingmethod.application.model.action.ShippingMethodUpdateAction;
import io.reactivesw.order.zone.application.model.action.ZoneUpdateAction;

/**
 * configurations for common update actions that will be used in more thant one services
 * and this action also extends other action configure in each service.
 * Created by umasuo on 16/11/21.
 * TODO this should be split to different class in each micro-service.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property =
    "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetName.class, name = "setName"),
    @JsonSubTypes.Type(value = SetDescription.class, name = "setDescription"),
    @JsonSubTypes.Type(value = SetLocalizedName.class, name = "setLocalizedName"),
    @JsonSubTypes.Type(value = SetLocalizedDescription.class, name = "setLocalizedDescription")
})
public interface UpdateAction
    extends
    CartDiscountUpdateAction,
    CartUpdateAction,
    DiscountCodeUpdateAction,
    ShippingMethodUpdateAction,
    ZoneUpdateAction {

}
