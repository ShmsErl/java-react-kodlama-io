package com.example.javareactkamp.exception;

public class ProductAlreadyExistsException extends   RuntimeException {
    public ProductAlreadyExistsException(String message) {
        super(message);
    }
}
