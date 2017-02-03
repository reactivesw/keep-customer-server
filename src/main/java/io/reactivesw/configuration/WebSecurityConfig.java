package io.reactivesw.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders
    .AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration
    .WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsUtils;

/**
 * Created by umasuo on 17/1/10.
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  /**
   * configure.
   *
   * @param http HttpSecurity
   * @throws Exception
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        .antMatchers("/**").permitAll()
//        .antMatchers("/admin/**").hasRole("ADMIN")
//        .antMatchers("/teacher/**").hasRole("CUSTOMER")
        .anyRequest().authenticated()
        .and().csrf().disable();
  }

  /**
   * global config.
   *
   * @param auth auth.
   * @throws Exception
   */
  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("user").password("password").roles("USER");
  }
}