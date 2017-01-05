package io.reactivesw.common.model.action;

import io.reactivesw.catalog.producttype.infrastructure.util.ProductTypeActionUtils;
import io.reactivesw.common.model.UpdateAction;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Davis on 16/12/8.
 */
@Getter
@Setter
public class SetDescription implements UpdateAction {
  /**
   * The Description.
   */
  @NotNull
  @Size(min = 1)
  private String description;

  @Override
  public String getActionName() {
    return ProductTypeActionUtils.SET_DESCRIPTION;
  }
}
