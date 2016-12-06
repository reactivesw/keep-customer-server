package io.reactivesw.common.models;

import io.swagger.annotations.ApiModel;
import org.hibernate.validator.constraints.NotEmpty;
import org.mapstruct.Qualifier;

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
   * The list of update actions to be performed on the category.
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
   * Gets actions.
   *
   * @return the actions
   */
  public List<UpdateAction> getActions() {
    return actions;
  }

  /**
   * Sets actions.
   *
   * @param actions the actions
   */
  public void setActions(List<UpdateAction> actions) {
    this.actions = actions;
  }

  @Override
  public String toString() {
    return "UpdateRequest{" +
        "version=" + version +
        ", actions=" + actions +
        '}';
  }
}
