package io.reactivesw.order.payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;

import io.reactivesw.order.payment.enums.TransactionState;
import io.reactivesw.order.payment.enums.TransactionType;
import io.reactivesw.common.model.Money;
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

  public ZonedDateTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(ZonedDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public TransactionType getType() {
    return type;
  }

  public void setType(TransactionType type) {
    this.type = type;
  }

  public Money getAmount() {
    return amount;
  }

  public void setAmount(Money amount) {
    this.amount = amount;
  }

  public String getInteractionId() {
    return interactionId;
  }

  public void setInteractionId(String interactionId) {
    this.interactionId = interactionId;
  }

  public TransactionState getState() {
    return state;
  }

  public void setState(TransactionState state) {
    this.state = state;
  }
}
