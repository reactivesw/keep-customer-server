package io.reactivesw.common.model;

import lombok.Data;

/**
 * Created by umasuo on 16/11/16.
 */
@Data
public class CustomFieldsDraft {
  /**
   * The Type.
   */
  private ResourceIdentifier type;

  /**
   * The Fields.
   */
  // TODO: 16/12/14 String should be Json object
  private String fields;
}
