package io.reactivesw.payments.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.ZonedDateTime;
import java.util.List;

import io.reactivesw.common.models.CustomFields;
import io.reactivesw.common.models.Money;
import io.reactivesw.common.models.Reference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
@ApiModel
public class Payment {

  @ApiModelProperty(required = true)
  private String id;

  @ApiModelProperty(required = true)
  private Integer version;

  @ApiModelProperty(value = "A reference to the customer this payment belongs to.",required = false)
  private Reference customer;

  @ApiModelProperty(value = "This ID can be used as an additional identifier for external systems like the systems involved in order or receivables management.",
          required = false)
  private String externalId;

  @ApiModelProperty(value = "The identifier that is used by the interface that manages the payment (usually the PSP). Cannot be changed once it has been set. " +
          "The combination of this ID and the PaymentMethodInfo paymentInterface must be unique.",
          required = false)
  private String interfaceId;

  @ApiModelProperty(value = "How much money this payment intends to receive from the customer. " +
          "The value usually matches the carts or order gross total.", required = true)
  private Money amountPlanned;

  @ApiModelProperty(value = "The amount of money that has been authorized (i.e. reliably reserved, but not transferred).", required = false)
  private Money amountAuthorized;

  @ApiModelProperty(value = "Until when the authorization is valid. Can only be set when amountAuthorized is set, too.", required = false)
  private String authorizedUntil;

  @ApiModelProperty(value = "The amount of money that has been received from the customer. " +
          "This value is updated during the financial process.",
          required = false)
  private Money amountPaid;

  @ApiModelProperty(value = "The amount of money that has been refunded to the customer.",
          required = false)
  private Money amountRefunded;

  @ApiModelProperty(required = true)
  private PaymentMethodInfo paymentMethodInfo;

  @ApiModelProperty(required = true)
  private PaymentStatus paymentStatus;

  @ApiModelProperty(value = "Array of Transaction A list of financial transactions of different TransactionTypes with different TransactionStates.", required = true)
  private List<Transaction> transactions;

  @ApiModelProperty(value = "Interface interactions can be requests sent to the PSP, responses received from the PSP or notifications received from the PSP. " +
          "Some interactions may result in a transaction. If so, the interactionId in the Transaction should be set to match the ID of the PSP for the interaction. " +
          "Interactions are managed by the PSP integration and are usually neither written nor read by the user facing frontends or other services.",
          required = true)
  private List<CustomFields> interfaceInteractions;

  @ApiModelProperty(required = false)
  private CustomFields custom;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime createdAt;

  @ApiModelProperty(required = true)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime lastModifiedAt;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Reference getCustomer() {
    return customer;
  }

  public void setCustomer(Reference customer) {
    this.customer = customer;
  }

  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public String getInterfaceId() {
    return interfaceId;
  }

  public void setInterfaceId(String interfaceId) {
    this.interfaceId = interfaceId;
  }

  public Money getAmountPlanned() {
    return amountPlanned;
  }

  public void setAmountPlanned(Money amountPlanned) {
    this.amountPlanned = amountPlanned;
  }

  public Money getAmountAuthorized() {
    return amountAuthorized;
  }

  public void setAmountAuthorized(Money amountAuthorized) {
    this.amountAuthorized = amountAuthorized;
  }

  public String getAuthorizedUntil() {
    return authorizedUntil;
  }

  public void setAuthorizedUntil(String authorizedUntil) {
    this.authorizedUntil = authorizedUntil;
  }

  public Money getAmountPaid() {
    return amountPaid;
  }

  public void setAmountPaid(Money amountPaid) {
    this.amountPaid = amountPaid;
  }

  public Money getAmountRefunded() {
    return amountRefunded;
  }

  public void setAmountRefunded(Money amountRefunded) {
    this.amountRefunded = amountRefunded;
  }

  public PaymentMethodInfo getPaymentMethodInfo() {
    return paymentMethodInfo;
  }

  public void setPaymentMethodInfo(PaymentMethodInfo paymentMethodInfo) {
    this.paymentMethodInfo = paymentMethodInfo;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public List<CustomFields> getInterfaceInteractions() {
    return interfaceInteractions;
  }

  public void setInterfaceInteractions(List<CustomFields> interfaceInteractions) {
    this.interfaceInteractions = interfaceInteractions;
  }

  public CustomFields getCustom() {
    return custom;
  }

  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(ZonedDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ZonedDateTime getLastModifiedAt() {
    return lastModifiedAt;
  }

  public void setLastModifiedAt(ZonedDateTime lastModifiedAt) {
    this.lastModifiedAt = lastModifiedAt;
  }
}
