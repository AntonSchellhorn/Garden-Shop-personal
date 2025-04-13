package com.gardenshop.personal.exception.handler;

import com.gardenshop.personal.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            UserNotFoundException.class,
            ProductNotFoundException.class,
            CategoryNotFoundException.class,
            OrderNotFoundException.class,
            OrderItemNotFoundException.class,
            CartNotFoundException.class,
            CartItemNotFoundException.class,
            FavoriteNotFoundException.class
    })
    public ResponseEntity<String> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Общий перехват
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleAll(Exception ex) {
        return new ResponseEntity<>("Внутренняя ошибка сервера: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
