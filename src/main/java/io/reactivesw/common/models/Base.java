package io.reactivesw.common.models;

/**
 *
 */

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * A base class which implements {@link Object#toString()}, {@link Object#hashCode()} and
 * {@link Object#equals(Object)} by reflection.
 * Created by umasuo on 16/11/21.
 */
public abstract class Base {

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }

  @Override
  public String toString() {
    return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        //important to not log passwords
        .setExcludeFieldNames("password", "newPassword", "currentPassword", "oldPassword",
            "access_token", "accessToken")
        .build();
  }
}
