package io.reactivesw.order.shippingmethod.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.reactivesw.common.model.UpdateAction;

/**
 * Created by umasuo on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property =
    "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddShippingRate.class, name = "addShippingRate"),
    @JsonSubTypes.Type(value = AddZone.class, name = "addZone"),
    @JsonSubTypes.Type(value = RemoveShippingRate.class, name = "removeShippingRate"),
    @JsonSubTypes.Type(value = RemoveZone.class, name = "removeZone"),
    @JsonSubTypes.Type(value = SetDefault.class, name = "setDefault"),
    @JsonSubTypes.Type(value = SetTaxCategory.class, name = "setTaxCategory")
})
public interface ShippingMethodUpdateAction {
}
