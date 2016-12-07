package io.reactivesw.common.util;

import org.springframework.data.domain.AuditorAware;

/**
 * Created by Davis on 16/11/28.
 */
public class ZonedDateTimeAuditorAware implements AuditorAware<String> {

  @Override
  public String getCurrentAuditor() {
    return null;
  }
}