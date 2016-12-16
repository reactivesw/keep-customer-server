package io.reactivesw.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


/**
 * Created by umasuo on 16/12/13.
 */
@Configuration
@Getter
@Setter
public class ApplicationConfig {

  /**
   * server port.
   */
  @Value("${server.port}")
  private int port;

  /**
   *
   */
  @Value("${app.domain.name}")
  private String domainName;
}
