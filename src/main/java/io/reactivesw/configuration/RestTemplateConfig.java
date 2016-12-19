package io.reactivesw.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Davis on 16/12/19.
 */
@Configuration
public class RestTemplateConfig {
  /**
   * Rest template bean.
   *
   * @return the rest template
   */
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
