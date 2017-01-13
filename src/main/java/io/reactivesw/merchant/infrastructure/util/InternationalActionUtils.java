package io.reactivesw.merchant.infrastructure.util;

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

  /**
   * The constant remove_support_currency.
   */
  public static final String REMOVE_SUPPORT_CURRENCY = INTERNATIONAL_ROOT +
      "remove_support_currency";

  /**
   * The constant set_default_language.
   */
  public static final String SET_DEFAULT_LANGUAGE = INTERNATIONAL_ROOT + "set_default_language";

  /**
   * The constant add_supported_language.
   */
  public static final String ADD_SUPPORTED_LANGUAGE = INTERNATIONAL_ROOT + "add_supported_language";

  /**
   * The constant remove_support_language.
   */
  public static final String REMOVE_SUPPORT_LANGUAGE = INTERNATIONAL_ROOT +
      "remove_supported_language";
}
