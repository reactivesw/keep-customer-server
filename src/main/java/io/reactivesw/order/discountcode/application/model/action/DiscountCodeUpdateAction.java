package io.reactivesw.order.discountcode.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by umasuo on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetActive.class, name = "setActive"),
    @JsonSubTypes.Type(value = SetCartDiscounts.class, name = "setCartDiscounts"),
    @JsonSubTypes.Type(value = SetCartPredicate.class, name = "setCartPredicate"),
    @JsonSubTypes.Type(value = SetMaxApplications.class, name = "setMaxApplications"),
    @JsonSubTypes.Type(value = SetMaxApplicationsPerCustomer.class, name = "setMaxApplicationsPerCustomer")

})
public interface DiscountCodeUpdateAction {
}
