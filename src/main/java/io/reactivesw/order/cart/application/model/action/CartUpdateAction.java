package io.reactivesw.order.cart.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.reactivesw.order.cartdiscount.application.model.action.SetActive;
import io.reactivesw.order.cartdiscount.application.model.action.SetCartPredicate;
import io.reactivesw.order.cartdiscount.application.model.action.SetRequiresDiscountCode;
import io.reactivesw.order.cartdiscount.application.model.action.SetSortOrder;
import io.reactivesw.order.cartdiscount.application.model.action.SetTarget;
import io.reactivesw.order.cartdiscount.application.model.action.SetValidFrom;
import io.reactivesw.order.cartdiscount.application.model.action.SetValidUntil;
import io.reactivesw.order.cartdiscount.application.model.action.SetValue;

/**
 * Created by umasuo on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddCustomLineItem.class, name = "addCustomLineItem"),
    @JsonSubTypes.Type(value = AddDiscountCode.class, name = "addDiscountCode"),
    @JsonSubTypes.Type(value = AddLineItem.class, name = "addLineItem"),
    @JsonSubTypes.Type(value = AddPayment.class, name = "addPayment"),
    @JsonSubTypes.Type(value = Recalculate.class, name = "recalculate"),
    @JsonSubTypes.Type(value = RemoveCustomLineItem.class, name = "removeCustomLineItem"),
    @JsonSubTypes.Type(value = RemoveDiscountCode.class, name = "removeDiscountCode"),
    @JsonSubTypes.Type(value = RemoveLineItem.class, name = "removeLineItem"),
    @JsonSubTypes.Type(value = RemovePayment.class, name = "removePayment"),
    @JsonSubTypes.Type(value = SetBillingAddress.class, name = "setBillingAddress"),
    @JsonSubTypes.Type(value = SetCountry.class, name = "setCountry"),
    @JsonSubTypes.Type(value = SetCustomerEmail.class, name = "setCustomerEmail"),
    @JsonSubTypes.Type(value = SetCustomerId.class, name = "setCustomerId"),
    @JsonSubTypes.Type(value = SetCustomField.class, name = "setCustomField"),
    @JsonSubTypes.Type(value = SetCustomLineItemCustomField.class, name = "setCustomLineItemCustomField"),
    @JsonSubTypes.Type(value = SetCustomLineItemCustomType.class, name = "setCustomLineItemCustomType"),
    @JsonSubTypes.Type(value = SetCustomLineItemMoney.class, name = "setCustomLineItemMoney"),
    @JsonSubTypes.Type(value = SetCustomLineItemQuantity.class, name = "setCustomLineItemQuantity"),
    @JsonSubTypes.Type(value = SetCustomLineItemTaxRate.class, name = "setCustomLineItemTaxRate"),
    @JsonSubTypes.Type(value = SetCustomShippingMethod.class, name = "setCustomShippingMethod"),
    @JsonSubTypes.Type(value = SetCustomType.class, name = "setCustomType"),
    @JsonSubTypes.Type(value = SetLineItemCustomField.class, name = "setLineItemCustomField"),
    @JsonSubTypes.Type(value = SetLineItemCustomType.class, name = "setLineItemCustomType"),
    @JsonSubTypes.Type(value = SetLineItemQuantity.class, name = "setLineItemQuantity"),
    @JsonSubTypes.Type(value = SetLineItemTaxRate.class, name = "setLineItemTaxRate"),
    @JsonSubTypes.Type(value = SetLineItemTotalPrice.class, name = "setLineItemTotalPrice"),
    @JsonSubTypes.Type(value = SetLocale.class, name = "setLocale"),
    @JsonSubTypes.Type(value = SetShippingAddress.class, name = "setShippingAddress"),
    @JsonSubTypes.Type(value = SetShippingMethod.class, name = "setShippingMethod"),
    @JsonSubTypes.Type(value = SetShippingMethodTaxRate.class, name = "setShippingMethodTaxRate"),
    @JsonSubTypes.Type(value = SetTaxMode.class, name = "setTaxMode")

})
public interface CartUpdateAction {
}
