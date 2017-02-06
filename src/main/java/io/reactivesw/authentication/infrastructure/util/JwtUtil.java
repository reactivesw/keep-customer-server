package io.reactivesw.authentication.infrastructure.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.reactivesw.common.model.Token;
import io.reactivesw.customer.customer.application.model.Customer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * Created by umasuo on 17/2/3.
 */
@Configuration
@Data
public class JwtUtil {

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiresin}")
  private Long expiresIn;

  /**
   * Tries to parse specified String as a JWT token. If successful, returns User object with
   * username, id and role prefilled (extracted from token).
   * If unsuccessful (token is invalid or not containing all required user properties), simply
   * returns null.
   *
   * @param token the JWT token to parse
   * @return the User object extracted from specified token or null if a token is invalid.
   */
  public Token parseToken(String token) {
    try {
      Claims body = Jwts.parser()
          .setSigningKey(secret)
          .parseClaimsJws(token)
          .getBody();

      Token tk = new Token();
      tk.setTokenType(body.getSubject());
      tk.setSubjectId((String) body.get("subjectId"));
      tk.setGenerateTime((Long) body.get("generateTime"));
      if (body.get("expiresIn") instanceof Integer) {
        tk.setExpiresIn(((Integer) body.get("expiresIn")).longValue());
      } else {
        tk.setExpiresIn((Long) body.get("expiresIn"));
      }
//      u.setScope((String) body.get("scope"));

      return tk;

    } catch (JwtException | ClassCastException e) {
      return null;
    }
  }

  /**
   * Generates a JWT token containing username as subject, and userId and role as additional
   * claims. These properties are taken from the specified
   * User object. Tokens validity is infinite.
   *
   * @param customer the user for which the token will be generated
   * @return the JWT token
   */
  public String generateToken(Customer customer) {
    Claims claims = Jwts.claims().setSubject("customer");
    claims.put("subjectId", customer.getId());
    claims.put("generateTime", System.currentTimeMillis());
    claims.put("expiresIn", expiresIn);
//    claims.put("scope", u.getRole());// TODO set role or scope

    return Jwts.builder()
        .setClaims(claims)
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  /**
   * generate service token for service.
   *
   * @param serviceId service name
   * @return String
   */
  public String generateServiceToken(String serviceId) {
    Claims claims = Jwts.claims().setSubject("service");
    claims.put("subjectId", serviceId);
    claims.put("generateTime", System.currentTimeMillis());
    claims.put("expiresIn", Integer.MAX_VALUE);
//    claims.put("scope", u.getRole());// TODO set role or scope

    return Jwts.builder()
        .setClaims(claims)
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  /**
   * generate anonymous token.
   *
   * @return String
   */
  public String generateAnonymousToken() {
    Claims claims = Jwts.claims().setSubject("anonymous");
    claims.put("subjectId", UUID.randomUUID().toString());//use uuid as customer id
    claims.put("generateTime", System.currentTimeMillis());
    claims.put("expiresIn", expiresIn);
//    claims.put("scope", u.getRole());// TODO set role or scope

    return Jwts.builder()
        .setClaims(claims)
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }
}
