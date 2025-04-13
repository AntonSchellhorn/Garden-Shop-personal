package com.gardenshop.personal.exception;

public class ProductNotFoundException extends RuntimeException {

  public ProductNotFoundException() {
    super("Товар не найден");
  }

  public ProductNotFoundException(String message) {
    super(message);
  }
}
