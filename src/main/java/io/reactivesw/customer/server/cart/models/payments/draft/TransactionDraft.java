package io.reactivesw.customer.server.cart.models.payments.draft;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.reactivesw.customer.server.cart.enums.payments.TransactionState;
import io.reactivesw.customer.server.cart.enums.payments.TransactionType;
import io.reactivesw.customer.server.common.types.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class TransactionDraft {

  @ApiModelProperty(value = "The time at which the transaction took place.", required = false)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime timestamp;

  @ApiModelProperty(value = "The type of this transaction.", required = true)
  private TransactionType type;

  @ApiModelProperty(required = true)
  private Money amount;

  @ApiModelProperty(value = "The identifier that is used by the interface that managed the transaction (usually the PSP). " +
          "If a matching interaction was logged in the interfaceInteractions array, the corresponding interaction should be findable with this ID.",
          required = false)
  private String interactionId;

  @ApiModelProperty(value = "The state of this transaction.",
          required = true)
  private TransactionState state;

}
