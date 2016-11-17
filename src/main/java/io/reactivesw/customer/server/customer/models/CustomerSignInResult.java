package io.reactivesw.customer.server.customer.models;

/**
 * Created by umasuo on 16/11/16.
 */
public class CustomerSignInResult {
  private Customer customer;

  @Override
  public String toString() {
    return "CustomerSignInResult{" +
            "customer=" + customer +
            '}';
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
