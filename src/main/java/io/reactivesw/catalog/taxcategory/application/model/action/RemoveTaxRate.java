package io.reactivesw.catalog.taxcategory.application.model.action;

import io.reactivesw.common.model.UpdateAction;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Davis on 16/12/11.
 */
@Getter
@Setter
public class RemoveTaxRate implements UpdateAction {
  /**
   * The Tax rate id.
   */
  private String taxRateId;

  @Override
  public String getActionName() {
    return null;
  }
}
