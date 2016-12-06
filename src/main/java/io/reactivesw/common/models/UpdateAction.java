package io.reactivesw.common.models;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Created by umasuo on 16/11/21.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "action")
@JsonSubTypes( {
//    @JsonSubTypes.Type(value = Action1.class, name = "action1"),
})
public interface UpdateAction {
}
