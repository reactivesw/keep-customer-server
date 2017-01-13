package io.reactivesw.authorization.application.controller;

import io.reactivesw.authorization.application.model.LoginResult;
import io.reactivesw.route.AuthorizationRouter;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 17/1/10.
 */
@RestController
public class LoginController {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(LoginController.class);

  /**
   * login with email.
   *
   * @param email    String
   * @param password String
   * @return LoginResult
   */
  @ApiOperation("login with email")
  @PostMapping(value = AuthorizationRouter.AUTHORIZATION_LOGIN, params = "email")
  public LoginResult loginWithEmail(@RequestParam String email, @RequestParam String password) {
    LOG.info("enter: email:", email);


    LOG.info("exit: customer:");
    return null;
  }


  /**
   * login with google.
   *
   * @param gToken String
   * @return LoginResult
   */
  @PostMapping(value = AuthorizationRouter.AUTHORIZATION_LOGIN, params = "gToken")
  public LoginResult loginWithGoogle(String gToken) {
    LOG.info("enter: gToken: {}", gToken);


    LOG.info("exit: customer:");
    return null;
  }

  /**
   * login with facebook.
   *
   * @param fbToken String
   * @return LoginResult
   */
  @PostMapping(value = AuthorizationRouter.AUTHORIZATION_LOGIN, params = "fbToken")
  public LoginResult loginWithFaceBook(String fbToken) {
    LOG.info("enter: gToken: {}", fbToken);


    LOG.info("exit: customer:");
    return null;
  }


}

