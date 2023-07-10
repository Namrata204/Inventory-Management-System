package com.inventory.management.exception;

/**
 * Exception thrown when a order is not found.
 */
public class OrderNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    /**
     * Constructs a new OrderNotFoundException with the specified error message.
     *
     * @param message The error message.
     */
    public OrderNotFoundException(String message) {
        super(message);
    }

}
