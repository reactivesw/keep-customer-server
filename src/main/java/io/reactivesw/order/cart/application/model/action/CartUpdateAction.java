package io.reactivesw.order.cart.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by umasuo on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddLineItem.class, name = "addLineItem"),
    @JsonSubTypes.Type(value = RemoveLineItem.class, name = "removeLineItem"),
    @JsonSubTypes.Type(value = SetBillingAddress.class, name = "setBillingAddress"),
    @JsonSubTypes.Type(value = SetCountry.class, name = "setCountry"),
    @JsonSubTypes.Type(value = SetCustomerId.class, name = "setSubjectId"),
    @JsonSubTypes.Type(value = SetLineItemQuantity.class, name = "setLineItemQuantity"),
    @JsonSubTypes.Type(value = SetShippingAddress.class, name = "setShippingAddress"),
    @JsonSubTypes.Type(value = SetShippingMethod.class, name = "setShippingMethod"),
    @JsonSubTypes.Type(value = SetTaxMode.class, name = "setTaxMode")
})
public interface CartUpdateAction {
}
