package io.reactivesw.customer.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bruceliu on 16/11/14.
 */
@RestController
public class TestController {


  @GetMapping("/test")
  public String testApi(){
    return "this is the test message";
  }
}
