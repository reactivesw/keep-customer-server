package io.reactivesw.order.payment.application.model;

import java.util.List;

import io.reactivesw.common.model.CustomFields;
import io.reactivesw.common.model.Money;
import io.reactivesw.common.model.Reference;
import io.reactivesw.common.model.CustomFieldsDraft;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by umasuo on 16/11/17.
 */
public class PaymentDraft {

  @ApiModelProperty(value = "A reference to the customer this payment belongs to.", required = false)
  private Reference customer;

  @ApiModelProperty(value = "This ID can be used as an additional identifier for external systems like the systems involved in order or receivables management.",
          required = false)
  private String externalId;

  @ApiModelProperty(value = "The identifier that is used by the interface that manages the payment (usually the PSP). " +
          "Cannot be changed once it has been set. " +
          "The combination of this ID and the PaymentMethodInfo paymentInterface must be unique.",
          required = false)
  private String interfaceId;

  @ApiModelProperty(value = "How much money this payment intends to receive from the customer. " +
          "The value usually matches the cart or order gross total.", required = true)
  private Money amountPlanned;

  @ApiModelProperty(value = "The amount of money that has been authorized (i.e. reliably reserved, but not transferred).",
          required = false)
  private Money amountAuthorized;

  @ApiModelProperty(value = "Until when the authentication is valid. Can only be set when amountAuthorized is set, too.",
          required = false)
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

  @ApiModelProperty(required = false)
  private CustomFields custom;

  @ApiModelProperty(required = true)
  private PaymentStatus paymentStatus;

  @ApiModelProperty(value = "Array of TransactionModel A list of financial transactions of different TransactionTypes with different TransactionStates.", required = true)
  private List<TransactionDraft> transactions;

  @ApiModelProperty(value = "Interface interactions can be requests sent to the PSP, responses received from the PSP or notifications received from the PSP. " +
          "Some interactions may result in a transaction. If so, the interactionId in the TransactionModel should be set to match the ID of the PSP for the interaction. " +
          "Interactions are managed by the PSP integration and are usually neither written nor read by the user facing frontends or other service.",
          required = true)
  private List<CustomFieldsDraft> interfaceInteractions;

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

  public CustomFields getCustom() {
    return custom;
  }

  public void setCustom(CustomFields custom) {
    this.custom = custom;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public List<TransactionDraft> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<TransactionDraft> transactions) {
    this.transactions = transactions;
  }

  public List<CustomFieldsDraft> getInterfaceInteractions() {
    return interfaceInteractions;
  }

  public void setInterfaceInteractions(List<CustomFieldsDraft> interfaceInteractions) {
    this.interfaceInteractions = interfaceInteractions;
  }
}
