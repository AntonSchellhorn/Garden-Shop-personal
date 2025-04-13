package com.gardenshop.personal.exception;

public class CategoryNotFoundException extends RuntimeException {

  public CategoryNotFoundException() {
    super("Категория не найдена");
  }

  public CategoryNotFoundException(String message) {
    super(message);
  }
}
