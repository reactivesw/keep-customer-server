package io.reactivesw.customer.server.common.types;

import io.reactivesw.customer.server.catalog.entities.CategoryEntity;

import java.lang.reflect.ParameterizedType;
import java.util.Objects;

/**
 * Created by Davis on 16/11/16.
 */
public class Reference<T> {
  /**
   * The Type id.
   */
  private String typeId;
  /**
   * The Id.
   */
  private String id;

  /**
   * Gets type id.
   *
   * @return the type id
   */
  public String getTypeId() {
    return typeId;
  }

  /**
   * Sets type id.
   *
   * @param typeId the type id
   */
  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * equals method.
   *
   * @param obj object to compare
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    boolean equalsResult = false;
    if (this == obj) {
      equalsResult = true;
    } else if (obj instanceof Reference) {
      final Reference other = (Reference) obj;
      equalsResult = Objects.equals(id, other.id) && Objects.equals(typeId, other.typeId);
    }
    return equalsResult;
  }

  /**
   * hashCode method.
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, typeId);
  }

  /**
   * toString method.
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Reference{" +
        "typeId='" + typeId + '\'' +
        ", id='" + id + '\'' +
        '}';
  }
}
