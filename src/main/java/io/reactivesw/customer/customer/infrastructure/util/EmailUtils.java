package io.reactivesw.customer.customer.infrastructure.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Properties;

import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by umasuo on 16/12/27.
 */
public class EmailUtils {
  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(EmailUtils.class);
  
  /**
   * send email.
   */
  public static void sendMessage(EmailMessage emailMsg) throws MessagingException {

    LOG.debug("emailMessage {}", emailMsg);

    // first step: setup session
    Session mailSession = createMailSession(emailMsg.getSmtpHost(), emailMsg.getFrom(),
        emailMsg.getFromUserPassword());

    // second step: setup the message
    MimeMessage message = createMailMessage(emailMsg.getFrom(), emailMsg.getTo(), mailSession,
        emailMsg.getSubject(), emailMsg.getContent(), emailMsg.getContentType());

    // send email
    Transport.send(message, message.getRecipients(RecipientType.TO));
    LOG.debug("sendMessage success.");
  }

  /**
   * create mail session for smtp connect.
   *
   * @param host     smtp host
   * @param from     from
   * @param password password of from
   * @return session
   */
  private static Session createMailSession(String host, String from, String password) {
    Properties props = new Properties();
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.starttls.enable", "true");// use STARTTLS
    props.put("mail.smtp.auth", "true"); // use authentication
    return Session.getInstance(props, new EmailAuthenticator(from, password));
  }

  /**
   * create mime message for send email.
   *
   * @return mime message
   * @throws MessagingException exception
   */
  private static MimeMessage createMailMessage(String from, String to, Session mailSession,
                                               String subject, String content, String contentType)
      throws MessagingException {
    InternetAddress fromAddress = new InternetAddress(from);
    InternetAddress toAddress = new InternetAddress(to);

    MimeMessage message = new MimeMessage(mailSession);
    message.setFrom(fromAddress);
    message.addRecipient(RecipientType.TO, toAddress);

    message.setSentDate(Calendar.getInstance().getTime());
    message.setSubject(subject);
    message.setContent(content, contentType);
    return message;
  }
}
