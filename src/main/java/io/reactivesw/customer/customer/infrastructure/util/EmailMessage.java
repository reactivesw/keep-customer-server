package io.reactivesw.customer.customer.infrastructure.util;

import io.reactivesw.configuration.ApplicationConfig;
import lombok.Data;

/**
 * Created by umasuo on 16/12/27.
 */
@Data
public class EmailMessage {

  /**
   * smtp host.
   */
  private String smtpHost;

  /**
   * from.
   */
  private String from;

  /**
   * from user password.
   */
  private String fromUserPassword;

  /**
   * to.
   */
  private String to;

  /**
   * subject.
   */
  private String subject;

  /**
   * content.
   */
  private String content;

  /**
   * content type.
   */
  private String contentType;

  /**
   * default constructor.
   */
  public EmailMessage() {
  }

  /**
   * constructor, TODO this should in an builder, not here.
   *
   * @param to         destination
   * @param appConfig  appConfig.
   * @param verifyLink verify link
   */
  public EmailMessage(String to, ApplicationConfig appConfig, String verifyLink) {
    this.smtpHost = appConfig.getSmtpHost();
    this.from = appConfig.getPublicEmail();
    this.fromUserPassword = appConfig.getPublicEmailPassword();
    this.subject = appConfig.getVerifySubject();
    this.to = to;
    this.content = this.getVerifyEmailContent(verifyLink);
    this.contentType = appConfig.getEmailType();
  }

  /**
   * get email content.
   * TODO refactor the content, and use the template.
   *
   * @param verifyLink verify link.
   * @return content
   */
  public String getVerifyEmailContent(String verifyLink) {
    StringBuffer content = new StringBuffer();
    content.append("<h4>Dear,</h4>");
    content.append("<i>You have register an account in our web site, please click the <a href='")
        .append(verifyLink).append("'>link</a> to verify your registration</i>");
    content.append("<hr>");
    content.append("<p>reactivesw group</p>");
    return content.toString();
  }

}
