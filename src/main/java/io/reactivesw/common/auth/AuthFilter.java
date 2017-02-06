package io.reactivesw.common.auth;

import io.reactivesw.authentication.infrastructure.util.JwtUtil;
import io.reactivesw.common.exception.AuthTokenMissingException;
import io.reactivesw.common.model.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.reactivesw.common.exception.AuthFailedException;
import io.reactivesw.common.exception.handler.ExceptionHandler;

/**
 * Created by Bruce on 16/11/15.
 */
//@Component
public class AuthFilter implements Filter {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

  /**
   * exclude url, that do not need token.
   */
  private static final List<String> EXCLUDE_URL = new ArrayList<>();

  static {
    EXCLUDE_URL.add("/auth");
    EXCLUDE_URL.add("/products");
    EXCLUDE_URL.add("/swagger");
    EXCLUDE_URL.add("/webjars");
    EXCLUDE_URL.add("/v2");
  }

  /**
   * JWT(json web token) util
   */
  @Autowired
  private transient JwtUtil jwtUtil;

  /**
   * init.
   */
  @Override
  public void init(FilterConfig arg0) throws ServletException {
    // do nothing
  }

  /**
   * auth filter.
   *
   * @param request  ServletRequest
   * @param response ServletResponse
   * @param next     FilterChain
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain next) throws IOException, ServletException {
    try {
      // verify if access should be granted
      String path = ((HttpServletRequest) request).getRequestURI();
      if (this.shouldCheckAuth(path)) {
        checkAuth((HttpServletRequest) request);// TODO enable later
      }

      next.doFilter(request, response);
    } catch (AuthFailedException ex) {
      LOG.debug("check auth failed. request:{}", request, ex);
      ExceptionHandler.setResponse((HttpServletRequest) request, (HttpServletResponse) response,
          null, ex);
    }
  }

  /**
   * check if the path should check auth.
   *
   * @param path
   * @return
   */
  private boolean shouldCheckAuth(String path) {
    return EXCLUDE_URL.parallelStream().noneMatch(
        s -> path.startsWith(s)
    );
  }

  /**
   * check auth function.
   *
   * @param request HttpServletRequest
   */
  private void checkAuth(HttpServletRequest request) {

    String header = request.getHeader("Authorization");

    if (header == null || !header.startsWith("Bearer ")) {
      throw new AuthTokenMissingException("No auth token found in request headers.");
    }

    String authToken = header.substring(7);

    Token token = jwtUtil.parseToken(authToken);
    checkTokenTime(token);
    //TODO check scope

    LOG.debug("customer auth token:{}", token);
  }

  /**
   * check if this token has expired.
   *
   * @param token
   */
  private void checkTokenTime(Token token) {
    if (token.getExpiresIn() == null || token.getGenerateTime() == null) {
      throw new AuthFailedException("Token is illegal： expire or generate time not found.");
    }
    long curTime = System.currentTimeMillis();
    if (token.getExpiresIn() + token.getGenerateTime() < curTime) {
      throw new AuthFailedException("Token is illegal： token has expired.");
    }
  }

  /**
   * destroy.
   */
  @Override
  public void destroy() {
    // do nothing
  }
}
