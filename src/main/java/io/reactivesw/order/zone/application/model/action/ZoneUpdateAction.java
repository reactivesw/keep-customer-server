package io.reactivesw.order.zone.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by umasuo on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property =
    "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = AddLocation.class, name = "addLocation"),
    @JsonSubTypes.Type(value = RemoveLocation.class, name = "removeLocation")
})
public interface ZoneUpdateAction {
}
