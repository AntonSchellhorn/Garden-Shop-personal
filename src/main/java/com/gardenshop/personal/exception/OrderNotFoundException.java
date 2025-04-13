package com.gardenshop.personal.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
        super("Заказ не найден");
    }

    public OrderNotFoundException(String message) {
        super(message);
    }
}
