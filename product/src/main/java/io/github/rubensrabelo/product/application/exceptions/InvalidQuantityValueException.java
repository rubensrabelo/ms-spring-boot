package io.github.rubensrabelo.product.application.exceptions;

public class InvalidQuantityValueException extends RuntimeException {
    public InvalidQuantityValueException(String message) {
        super(message);
    }
}
