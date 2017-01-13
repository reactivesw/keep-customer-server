package io.reactivesw.common.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.reactivesw.common.exception.AuthenticationFailedException;
import io.reactivesw.common.exception.handler.ExceptionHandler;

/**
 * Created by Bruce on 16/11/15.
 */
@Component
public class AuthFilter implements Filter {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

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
      checkCallAuthorization((HttpServletRequest) request);

      next.doFilter(request, response);
    } catch (AuthenticationFailedException ex) {
      LOG.debug("check auth failed. request:{}", request, ex);
      ExceptionHandler.setResponse((HttpServletRequest) request, (HttpServletResponse) response, null, ex);
    }
  }

  /**
   * check auth function.
   *
   * @param request HttpServletRequest
   */
  private void checkCallAuthorization(HttpServletRequest request) {
    // TODO  check if the call is legal
    String token = request.getHeader("customer_auth_token");
    LOG.debug("customer auth token:{}", token);
//    throw new AuthenticationFailedException();
  }

  /**
   * destroy.
   */
  @Override
  public void destroy() {
    // do nothing
  }
}
