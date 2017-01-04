package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/20.
 */
public class ZoneRouter extends BaseRouter {

  /**
   * ZONE ID.
   */
  public static final String ZONE_ID = "id";

  /**
   * ZONE BASE URL.
   */
  public static final String ZONE_ROOT = URL_ROOT + "/zones";

  /**
   * ZONE IDENTIFIED BY ID.
   */
  public static final String ZONE_WITH_ID = ZONE_ROOT + "/{" + ZONE_ID + "}";

}
