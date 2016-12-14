package io.reactivesw.common.model;

import io.swagger.annotations.ApiModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by umasuo on 16/11/16.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
