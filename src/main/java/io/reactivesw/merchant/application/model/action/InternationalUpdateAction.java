package io.reactivesw.merchant.application.model.action;

/**
 * Created by Davis on 17/1/9.
 */

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property =
    "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetDefaultCurrencyAction.class, name = "setDefaultCurrency"),
    @JsonSubTypes.Type(value = AddSupportCurrencyAction.class, name = "addSupportCurrency"),
    @JsonSubTypes.Type(value = RemoveSupportCurrencyAction.class, name = "removeSupportCurrency"),
    @JsonSubTypes.Type(value = SetDefaultLanguageAction.class, name = "setDefaultLanguage"),
    @JsonSubTypes.Type(value = AddSupportLanguageAction.class, name = "addSupportLanguage"),
    @JsonSubTypes.Type(value = RemoveSupportLanguageAction.class, name = "removeSupportLanguage"),
})
public interface InternationalUpdateAction {
}
