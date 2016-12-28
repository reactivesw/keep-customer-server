package io.reactivesw.customer.customer.infrastructure.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by umasuo on 16/12/26.
 */
public class PasswordUtil {

  /**
   * encrypt tool.
   */
  private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

  /**
   * hash raw password.
   *
   * @param password raw password.
   * @return hashed password
   */
  public static String hashPassword(String password) {
    return bCryptPasswordEncoder.encode(password);
  }

  /**
   * check if the password if correct.
   *
   * @param originalPassword raw password
   * @param hashedPassword   hashed password
   * @return result.
   */
  public static boolean checkPassword(String originalPassword, String hashedPassword) {
    return bCryptPasswordEncoder.matches(originalPassword, hashedPassword);
  }

}
