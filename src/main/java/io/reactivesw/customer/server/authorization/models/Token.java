package io.reactivesw.customer.server.authorization.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/21.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class Token {

  @JsonProperty("access_token")
  private String accessToken;

  @ApiModelProperty("expire time in secondes")
  @JsonProperty("expires_in")
  private Long expiresIn;

  @JsonProperty("scope")
  private String scope;

  @JsonProperty("refresh_token")
  private String refreshToken;

  @JsonProperty("token_type")
  private String tokenType;

  @Override
  public String toString() {
    return "Token{" +
            "accessToken='" + accessToken + '\'' +
            ", expiresIn=" + expiresIn +
            ", scope='" + scope + '\'' +
            ", refreshToken='" + refreshToken + '\'' +
            ", tokenType='" + tokenType + '\'' +
            '}';
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  public Long getExpiresIn() {
    return expiresIn;
  }

  public void setExpiresIn(Long expiresIn) {
    this.expiresIn = expiresIn;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public void setRefreshToken(String refreshToken) {
    this.refreshToken = refreshToken;
  }

  public String getTokenType() {
    return tokenType;
  }

  public void setTokenType(String tokenType) {
    this.tokenType = tokenType;
  }
}
