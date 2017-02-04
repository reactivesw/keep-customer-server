package io.reactivesw.authentication.application.controller;

import io.reactivesw.authentication.application.model.LoginResult;
import io.reactivesw.authentication.application.service.SignupApplication;
import io.reactivesw.customer.customer.application.model.SignupWithEmail;
import io.reactivesw.route.AuthorizationRouter;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  @Autowired
  private transient SignupApplication signupApplication;


  /**
   * generate the token.
   *
   * @param emailModel
   * @return
   */
  @ApiOperation("sign up with email & password")
  @PostMapping(AuthorizationRouter.AUTHORIZATION_SIGN_UP)
  public LoginResult signupWithEmail(@RequestBody SignupWithEmail emailModel) {
    LOG.info("enter: email:", emailModel.getEmail());

    LoginResult result = signupApplication.signupWithEmail(emailModel.getEmail(), emailModel
        .getPassword());

    LOG.info("exit: loginResult:", result);
    return result;
  }
}

