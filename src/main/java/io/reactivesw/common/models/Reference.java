package io.reactivesw.common.models;

import io.swagger.annotations.ApiModel;

/**
 * Created by umasuo on 16/11/16.
 */
@ApiModel
public class Reference {
  /**
   * type id.
   */
  private String typeId;

  /**
   * id.
   */
  private String id;

  /**
   * no params constructor.
   */
  public Reference() {
  }

  /**
   * Instantiates a new Reference.
   *
   * @param typeId the type id
   * @param id     the id
   */
  public Reference(String typeId, String id) {
    this.typeId = typeId;
    this.id = id;
  }

  @Override
  public String toString() {
    return "Reference{" +
            "typeId='" + typeId + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

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
}
