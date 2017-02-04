/*
 * Copyright (c) 2014-2015 Huami, Inc. All Rights Reserved.
 */

package io.reactivesw.common.exception.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.reactivesw.common.exception.ConflictException;
import io.reactivesw.common.exception.NotExistException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.ImmutableList;

import io.reactivesw.common.exception.AlreadyExistException;
import io.reactivesw.common.exception.AuthFailedException;

/**
 * Created by BruceLiu on 16/11/14.
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandler.class);

  /**
   * exception EXCEPTION_MAP.
   */
  private static final Map<Class<?>, HttpStatus> EXCEPTION_MAP = new ConcurrentHashMap<>();

  /**
   * exception that do not log.
   */
  private static final ImmutableList<?> OMITTED_EXCEPTIONS = ImmutableList
      .of(AlreadyExistException.class, AuthFailedException.class);

  static {
    EXCEPTION_MAP.put(AlreadyExistException.class, HttpStatus.CONFLICT);
    EXCEPTION_MAP.put(AuthFailedException.class, HttpStatus.UNAUTHORIZED);
    EXCEPTION_MAP.put(NotExistException.class, HttpStatus.NOT_FOUND);
    EXCEPTION_MAP.put(ConflictException.class, HttpStatus.CONFLICT);
  }

  /**
   * set status to http response .
   *
   * @param request  HttpServletRequest
   * @param response HttpServletResponse
   * @param obj      Object
   * @param ex       Exception
   * @return Throwable
   */
  public static Throwable setResponse(HttpServletRequest request, HttpServletResponse response,
                                      Object obj,
                                      Exception ex) {
    Throwable throwable = ex;

    HttpStatus status;

    // get the status
    status = EXCEPTION_MAP.get(throwable.getClass());
    if (status == null) {
      //if this is an unexpected exception, set the code to internal server error.
      status = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    if (shouldLogException(ex)) {
      // only log those ones that are real failures
      LOG.error("request {}, response {}, obj {}, status {}", request, response, obj, status,
          throwable);

    }

    response.setStatus(status.value());
    response.setHeader("error message", ex.getMessage());
    response.setContentType(MediaType.APPLICATION_JSON.getType());
    return throwable;
  }

  /**
   * check if should log the exception's trace.
   *
   * @param ex exception
   * @return boolean
   */
  private static boolean shouldLogException(Exception ex) {
    // only log exception that we don't expect
    LOG.debug("expected exception thrown, message = {}", ex.getMessage());
    return !OMITTED_EXCEPTIONS.contains(ex.getClass());
  }

  /**
   * Try to resolve the given exception that got thrown during handler execution,
   * returning a {@link ModelAndView} that represents a specific error page if appropriate.
   * <p>The returned {@code ModelAndView} may be {@linkplain ModelAndView#isEmpty() empty}
   * to indicate that the exception has been resolved successfully but that no view
   * should be rendered, for instance by setting a status code.
   *
   * @param request  current HTTP request
   * @param response current HTTP response
   * @param obj      the executed handler, or {@code null} if none chosen at the time of the
   *                 exception (for example, if multipart resolution failed)
   * @param ex       the exception that got thrown during handler execution
   * @return a corresponding {@code ModelAndView} to forward to, or {@code null} for default
   * processing
   */
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                       Object obj, Exception ex) {
    setResponse(request, response, obj, ex);
    return new ModelAndView();
  }

}