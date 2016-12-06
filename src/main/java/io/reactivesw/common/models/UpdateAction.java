package io.reactivesw.common.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.reactivesw.orders.carts.applications.models.actions.AddLineItem;
import io.reactivesw.orders.carts.applications.models.actions.RemoveLineItem;

/**
 * configurations for update action.
 * Created by umasuo on 16/11/21.
 * TODO this should be split to different class in each micro-service.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddLineItem.class, name = "addLineItem"),
    @JsonSubTypes.Type(value = RemoveLineItem.class, name = "removeLineItem"),
})
public interface UpdateAction {
}
