package io.reactivesw.project.application.model;

import lombok.Data;

import java.util.List;

/**
 * Created by umasuo on 17/1/5.
 */
@Data
public class International {

  /**
   * supported currency in this project.
   */
  List<Currency> currencyList;

}
