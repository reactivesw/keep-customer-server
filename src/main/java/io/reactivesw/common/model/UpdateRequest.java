package io.reactivesw.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

import lombok.Data;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Davis on 16/11/21.
 */
@ApiModel
@Data
public class UpdateRequest {
  /**
   * The expected version of the category on which the changes should be applied.
   * If the expected version does not match the actual version, a 409 Conflict will be returned.
   */
  @NotNull
  @Min(0)
  Integer version;

  /**
   * Array of UpdateAction.
   * The list of update action to be performed on the category.
   * Required.
   */
  @NotNull
  @Valid
  List<UpdateAction> actions;

}
