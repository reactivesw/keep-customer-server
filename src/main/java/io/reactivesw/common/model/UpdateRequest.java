package io.reactivesw.common.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Davis on 16/11/21.
 */
@ApiModel
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
  List<UpdateAction> actions;

  /**
   * Gets version.
   *
   * @return the version
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * Sets version.
   *
   * @param version the version
   */
  public void setVersion(Integer version) {
    this.version = version;
  }

  /**
   * Gets action.
   *
   * @return the action
   */
  public List<UpdateAction> getActions() {
    return actions;
  }

  /**
   * Sets action.
   *
   * @param actions the action
   */
  public void setActions(List<UpdateAction> actions) {
    this.actions = actions;
  }

  @Override
  public String toString() {
    return "UpdateRequest{" +
        "version=" + version +
        ", action=" + actions +
        '}';
  }
}
