package com.gardenshop.personal.exception;

public class FavoriteNotFoundException extends RuntimeException {

  public FavoriteNotFoundException() {
    super("Избранный товар не найден");
  }

  public FavoriteNotFoundException(String message) {
    super(message);
  }
}
