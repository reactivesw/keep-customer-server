package io.reactivesw.catalog.producttype.application.model.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by Davis on 16/12/22.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,
    property = "action")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = SetName.class, name = "setName"),
    @JsonSubTypes.Type(value = SetDescription.class, name = "setDescription"),
    @JsonSubTypes.Type(value = AddAttributeDefinition.class, name = "addAttributeDefinition"),
    @JsonSubTypes.Type(value = RemoveAttributeDefinition.class, name = "removeAttributeDefinition"),
    @JsonSubTypes.Type(value = SetAttributeLabel.class, name = "setLabel"),
    @JsonSubTypes.Type(value = SetAttributeInputTip.class, name = "setInputTip"),
    @JsonSubTypes.Type(value = AddPlainEnumValue.class, name = "addPlainEnumValue"),
    @JsonSubTypes.Type(value = AddLocalizedEnumValue.class, name = "addLocalizedEnumValue"),
    @JsonSubTypes.Type(value = SetAttributeOrder.class, name = "setAttributeOrder"),
    @JsonSubTypes.Type(value = SetPlainEnumValueOrder.class, name = "setPlainEnumValueOrder"),
    @JsonSubTypes.Type(value = SetLocalizedEnumValueOrder.class,
        name = "setLocalizedEnumValueOrder"),
    @JsonSubTypes.Type(value = SetPlainEnumValueLabel.class, name = "setPlainEnumValueLabel"),
    @JsonSubTypes.Type(value = SetLocalizedEnumValueLabel.class,
        name = "setLocalizedEnumValueLabel"),
})
public interface ProductTypeUpdateAction {
}
