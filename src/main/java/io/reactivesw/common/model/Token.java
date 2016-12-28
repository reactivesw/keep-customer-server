package io.reactivesw.common.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by umasuo on 16/11/21.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
@Data
public class Token implements Serializable{

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
}
