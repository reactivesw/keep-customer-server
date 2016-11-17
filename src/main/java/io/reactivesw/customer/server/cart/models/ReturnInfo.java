package io.reactivesw.customer.server.cart.models;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by Davis on 16/11/17.
 */
public class ReturnInfo {

  /**
   * Array of ReturnItem
   */
  private List<ReturnItem> items;

  /**
   * Identifies, which return tracking ID is connected to this particular return.
   */
  private String returnTrackingId;


  /**
   * The Return date.
   */
  private ZonedDateTime returnDate;

}
