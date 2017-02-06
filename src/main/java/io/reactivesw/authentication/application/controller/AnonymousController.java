package io.reactivesw.authentication.application.controller;

import io.reactivesw.authentication.infrastructure.util.JwtUtil;
import io.reactivesw.route.AuthorizationRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umasuo on 17/2/6.
 */
@RestController
public class AnonymousController {

  /**
   * logger.
   */
  private final static Logger LOG = LoggerFactory.getLogger(AnonymousController.class);

  /**
   * token util.
   */
  @Autowired
  private transient JwtUtil jwtUtil;

  /**
   * login with facebook.
   */
  @GetMapping(value = AuthorizationRouter.AUTHORIZATION_ANONYMOUS)
  public String getAnonymousToken() {
    LOG.info("enter");
    String token = jwtUtil.generateAnonymousToken();

    LOG.info("exit: token: {}", token);
    return token;
  }


}

