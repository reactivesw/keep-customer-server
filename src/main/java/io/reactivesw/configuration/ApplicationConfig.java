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
  @Value("${server.port:8808}")
  private int port;

  /**
   * domain name.
   */
  @Value("${app.domain.name:http://www.umasuo.com/verify_email}")
  private String domainName;

  /**
   * smtp host.
   */
  @Value("${email.smtp.host:smtp.gmail.com}")
  private String smtpHost;

  /**
   * public email for send email
   */
  @Value("${email.public.email:test@test.com}")
  private String publicEmail;

  /**
   * public email password.
   */
  @Value("${email.public.email.password:password}")
  private String publicEmailPassword;

  /**
   * verify subject.
   */
  @Value("${email.verify.subject:Please Verify Your Email.}")
  private String verifySubject;

  /**
   * verify content.
   */
  @Value("${email.verify.content:text/html;Dear, \n \r \t \n}")
  private String verifyContent;

  /**
   * email type.
   */
  @Value("${email.type:text/html;charset=gb2312}")
  private String emailType;
}
