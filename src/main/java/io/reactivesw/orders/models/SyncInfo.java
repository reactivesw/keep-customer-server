package io.reactivesw.orders.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.reactivesw.common.models.Reference;

import java.time.ZonedDateTime;

/**
 * Created by Davis on 16/11/17.
 */
public class SyncInfo {

  /**
   * Reference to a Channel.
   * Connection to particular synchronization destination.
   */
  private Reference channel;

  /**
   * Can be used to reference an external order instance, file etc.
   */
  private String externalId;


  /**
   * The Synced at.
   */
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
  private ZonedDateTime syncedAt;

  public Reference getChannel() {
    return channel;
  }

  public void setChannel(Reference channel) {
    this.channel = channel;
  }

  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public ZonedDateTime getSyncedAt() {
    return syncedAt;
  }

  public void setSyncedAt(ZonedDateTime syncedAt) {
    this.syncedAt = syncedAt;
  }
}
