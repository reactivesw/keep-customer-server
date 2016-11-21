package io.reactivesw.common.models;

import io.swagger.annotations.ApiModel;

/**
 * Created by umasuo on 16/11/16.
 */
@ApiModel
public class Reference {
  private String typeId;
  private String id;

  @Override
  public String toString() {
    return "Reference{" +
            "typeId='" + typeId + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  public String getTypeId() {
    return typeId;
  }

  public void setTypeId(String typeId) {
    this.typeId = typeId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
