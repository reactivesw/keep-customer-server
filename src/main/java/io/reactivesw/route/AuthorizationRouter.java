package io.reactivesw.route;

/**
 * Created by umasuo on 17/1/10.
 */
public final class AuthorizationRouter extends BaseRouter {

  /**
   * authentication root.
   */
  public static final String AUTHORIZATION_ROOT = "/auth";

  /**
   * login.
   */
  public static final String AUTHORIZATION_LOGIN = AUTHORIZATION_ROOT + "/signin";

  /**
   * logout.
   */
  public static final String AUTHORIZATION_LOGOUT = AUTHORIZATION_ROOT + "/signout";

  /**
   * sign up.
   */
  public static final String AUTHORIZATION_SIGN_UP = AUTHORIZATION_ROOT + "/signup";

  /**
   * private default constructor.
   */
  private AuthorizationRouter() {
    super();
  }


}
