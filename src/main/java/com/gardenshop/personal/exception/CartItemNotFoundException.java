package com.gardenshop.personal.exception;

public class CartItemNotFoundException extends RuntimeException {

  public CartItemNotFoundException() {
    super("Товар в корзине не найден");
  }

  public CartItemNotFoundException(String message) {
    super(message);
  }
}
