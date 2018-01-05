package controller;

import org.springframework.beans.factory.annotation.Autowired;

import service.ProductServiceImpl;
import service.UserServiceImpl;

public class ParentController {

  @Autowired
  protected ProductServiceImpl productService;

  @Autowired
  protected UserServiceImpl userService;

  protected boolean checkData(String cf, String name, String surname) {
    return (cf != null && !cf.isEmpty() && cf.trim().length() > 0)
        && (name != null && !name.isEmpty() && name.trim().length() > 0)
        && (surname != null && !surname.isEmpty() && surname.trim().length() > 0);
  }

  public boolean ifNull(String string) {
    if (string != null && !string.isEmpty() && string.trim().length() > 0) {
      return false;
    } else {
      return true;
    }
  }
}
