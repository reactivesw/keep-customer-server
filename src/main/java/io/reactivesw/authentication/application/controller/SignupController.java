package io.reactivesw.authentication.application.controller;

import io.reactivesw.authentication.application.model.LoginResult;
import io.reactivesw.authentication.application.service.SignupApplication;
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
public class SignupController {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(SignupController.class);

  /**
   * login service.
   */
  private transient SignupApplication signupApplication;


  /**
   * generate the token.
   *
   * @param email
   * @param password
   * @return
   */
  @ApiOperation("sign up with email & password")
  @PostMapping(AuthorizationRouter.AUTHORIZATION_SIGN_UP)
  public LoginResult signupWithEmail(@RequestParam String email, @RequestParam String password) {
    LOG.info("enter: email:", email);

    LoginResult result = signupApplication.signupWithEmail(email, password);

    LOG.info("exit: loginResult:", result);
    return result;
  }
}

