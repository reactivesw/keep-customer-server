package io.reactivesw.orders.models;

import com.fasterxml.jackson.annotation.JsonFormat;

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
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime returnDate;

  public List<ReturnItem> getItems() {
    return items;
  }

  public void setItems(List<ReturnItem> items) {
    this.items = items;
  }

  public String getReturnTrackingId() {
    return returnTrackingId;
  }

  public void setReturnTrackingId(String returnTrackingId) {
    this.returnTrackingId = returnTrackingId;
  }

  public ZonedDateTime getReturnDate() {
    return returnDate;
  }

  public void setReturnDate(ZonedDateTime returnDate) {
    this.returnDate = returnDate;
  }
}
