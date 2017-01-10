package io.reactivesw.route;

/**
 * Created by umasuo on 17/1/5.
 */
public final class ProjectRouter extends BaseRouter {

  /**
   * project root.
   */
  public static final String PROJECT_ROOT = URL_ROOT + "/projects";

  /**
   * project international root.
   */
  public static final String INTERNATIONAL_ROOT = PROJECT_ROOT + "/international";

  /**
   * The constant default_currency_root.
   */
  public static final String DEFAULT_CURRENCY_ROOT = INTERNATIONAL_ROOT + "/default-currency";

  /**
   * The constant support_currency_root.
   */
  public static final String SUPPORT_CURRENCY_ROOT = INTERNATIONAL_ROOT + "/support-currencies";

  /**
   * The constant default_language_root.
   */
  public static final String DEFAULT_LANGUAGE_ROOT = INTERNATIONAL_ROOT + "/default-language";

  /**
   * The constant support_language_root.
   */
  public static final String SUPPORT_LANGUAGE_ROOT = INTERNATIONAL_ROOT + "/support-languages";
}
