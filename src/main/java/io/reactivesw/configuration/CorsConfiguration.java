package io.reactivesw.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;

/**
 * Created by Davis on 16/12/16.
 */
// TODO: 16/12/16 add for CORS, if somethings wrong, should remove
@Configuration
public class CorsConfiguration {
  /**
   * Cors configurer web mvc configurer.
   *
   * @return the web mvc configurer
   */
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurerAdapter() {
      /**
       * add Cors rule.
       * @param registry resigtry
       */
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedHeaders("*")
            .allowedMethods("*")
            .allowedOrigins("*");
      }
    };
  }

  /**
   * Cors filter filter registration bean.
   * TODO fix cors bug, if somethings wrong, should remove
   * @return the filter registration bean
   */
  @Bean
  public FilterRegistrationBean corsFilter(){
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    org.springframework.web.cors.CorsConfiguration config = new org.springframework.web.cors
        .CorsConfiguration();
    config.setAllowCredentials(true);
    config.setAllowedOrigins(Arrays.asList("*"));
    config.setAllowedHeaders(Arrays.asList("*"));
    config.setAllowedMethods(Arrays.asList("*"));
    source.registerCorsConfiguration("/**", config);
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new CorsFilter
        (source));
    filterRegistrationBean.setOrder(0);
    return filterRegistrationBean;
  }
}