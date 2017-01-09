package io.reactivesw.project.application.model.action;

/**
 * Created by Davis on 17/1/9.
 */

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.reactivesw.catalog.inventory.application.model.action.AddQuantityAction;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property =
    "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetDefaultCurrencyAction.class, name = "setDefaultCurrency"),
    @JsonSubTypes.Type(value = AddSupportCurrencyAction.class, name = "addSupportCurrency"),
    @JsonSubTypes.Type(value = RemoveSupportCurrencyAction.class, name = "removeSupportCurrency"),
})
public interface InternationalUpdateAction {
}
