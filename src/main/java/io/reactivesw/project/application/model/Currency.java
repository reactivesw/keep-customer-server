package io.reactivesw.project.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by umasuo on 17/1/5.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Currency {
  /**
   * currency code.
   */
  @NotNull
  @Size(min = 2)
  private String currencyCode;

  /**
   * conversion factor.
   */
  @NotNull
  @Size(min = 1)
  private String conversionFactor;

  /**
   * name.
   */
  @NotNull
  @Size(min = 2)
  private String name;
}
