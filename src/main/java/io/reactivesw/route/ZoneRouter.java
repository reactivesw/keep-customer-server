package io.reactivesw.route;

/**
 * Created by umasuo on 16/12/20.
 */
public final class ZoneRouter extends BaseRouter {

  /**
   * ZONE BASE URL.
   */
  public static final String ZONE_ROOT = URL_ROOT + "/zones";

  /**
   * ZONE ID.
   */
  public static final String ZONE_ID = "id";

  /**
   * ZONE IDENTIFIED BY ID.
   */
  public static final String ZONE_WITH_ID = ZONE_ROOT + "/{" + ZONE_ID + "}";

  /**
   * private default constructor.
   */
  private ZoneRouter() {
    super();
  }

  /**
   * path builder: get zone by id.
   *
   * @param id String
   * @return String
   */
  public static String getZoneWithId(String id) {
    return ZONE_ROOT + "/" + id;
  }
}
