package com.gardenshop.personal.exception;

public class CartNotFoundException extends RuntimeException {

    public CartNotFoundException() {
        super("Корзина не найдена");
    }

    public CartNotFoundException(String message) {
        super(message);
    }
}
