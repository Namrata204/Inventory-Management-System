package com.inventory.management.exception;


/**
 * Exception thrown when a product is not found.
 */
public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ProductNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public ProductNotFoundException(String message) {
        super(message);
    }
}


