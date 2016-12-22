package io.reactivesw.order.zone.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.reactivesw.common.model.action.SetDescription;
import io.reactivesw.common.model.action.SetLocalizedDescription;
import io.reactivesw.common.model.action.SetLocalizedName;
import io.reactivesw.common.model.action.SetName;

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
