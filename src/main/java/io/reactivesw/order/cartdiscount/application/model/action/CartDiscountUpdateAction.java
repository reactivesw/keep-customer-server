package io.reactivesw.order.cartdiscount.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * here is the configuration for all actions that only used in cart discount service.
 * Created by umasuo on 16/12/21.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetValue.class, name = "setValue"),
    @JsonSubTypes.Type(value = SetActive.class, name = "setActive"),
    @JsonSubTypes.Type(value = SetRequiresDiscountCode.class, name = "setRequiresDiscountCode"),
    @JsonSubTypes.Type(value = SetSortOrder.class, name = "setSortOrder"),
    @JsonSubTypes.Type(value = SetTarget.class, name = "setTarget"),
    @JsonSubTypes.Type(value = SetValidFrom.class, name = "setValidFrom"),
    @JsonSubTypes.Type(value = SetValidUntil.class, name = "setValidUntil"),
    @JsonSubTypes.Type(value = SetCartPredicate.class, name = "setCartPredicate")

})
public interface CartDiscountUpdateAction {
}
