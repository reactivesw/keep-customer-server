package io.reactivesw.order.payment.application.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.reactivesw.order.payment.infrastructure.enums.TransactionState;
import io.reactivesw.order.payment.infrastructure.enums.TransactionType;
import io.reactivesw.common.model.Money;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * A representation of a financial transactions. Transactions are either created by the solution
 * implementation to trigger a new transaction at the PSP or created by the PSP integration as the
 * result of a notification by the PSP. Created by umasuo on 16/11/17.
 */
@ApiModel(description = "A representation of a financial transactions. " +
        "Transactions are either created by the solution implementation to trigger a new transaction at the PSP or created by the PSP integration as the result of a notification by the PSP.")
@Getter
@Setter
public class TransactionModel {

  @ApiModelProperty(value = "The unique ID of this object.", required = true)
  private String id;

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
