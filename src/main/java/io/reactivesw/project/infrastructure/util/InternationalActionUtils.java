package io.reactivesw.project.infrastructure.util;

/**
 * Created by Davis on 17/1/9.
 */
public final class InternationalActionUtils {
  /**
   * Instantiates a new International action utils.
   */
  private InternationalActionUtils() {
  }

  private static final String INTERNATIONAL_ROOT = "project_international_";

  /**
   * The constant set_default_currency.
   */
  public static final String SET_DEFAULT_CURRENCY = INTERNATIONAL_ROOT + "set_default_currency";


  /**
   * The constant add_support_currency.
   */
  public static final String ADD_SUPPORT_CURRENCY = INTERNATIONAL_ROOT + "add_support_currency";
}
