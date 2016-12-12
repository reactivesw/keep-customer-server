package io.reactivesw.catalog.product.model.attributes;

/**
 * Created by Davis on 16/11/16.
 */

import io.reactivesw.order.cart.application.model.action.AddLineItem;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "name")
@JsonSubTypes( {
    @JsonSubTypes.Type(value = BooleanAttributeType.class, name = "boolean"),
    @JsonSubTypes.Type(value = StringAttributeType.class, name = "text"),
    @JsonSubTypes.Type(value = LocalizedStringAttributeType.class, name = "ltext"),
    @JsonSubTypes.Type(value = EnumAttributeType.class, name = "enum"),
    @JsonSubTypes.Type(value = LocalizedEnumAttributeType.class, name = "lenum"),
    @JsonSubTypes.Type(value = NumberAttributeType.class, name = "number"),
    @JsonSubTypes.Type(value = MoneyAttributeType.class, name = "money"),
    @JsonSubTypes.Type(value = DateAttributeType.class, name = "date"),
    @JsonSubTypes.Type(value = TimeAttributeType.class, name = "time"),
    @JsonSubTypes.Type(value = DateTimeAttributeType.class, name = "datetime"),
    @JsonSubTypes.Type(value = ReferenceAttributeType.class, name = "reference"),
    @JsonSubTypes.Type(value = SetAttributeType.class, name = "set"),
    @JsonSubTypes.Type(value = NestedAttributeType.class, name = "nested")
})
public interface AttributeType {

}
