package com.gardenshop.personal.exception;

public class OrderItemNotFoundException extends RuntimeException {

  public OrderItemNotFoundException() {
    super("Элемент заказа не найден");
  }

  public OrderItemNotFoundException(String message) {
    super(message);
  }
}
