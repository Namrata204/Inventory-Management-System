package com.inventory.management.exception;

/**
 * Exception thrown when there is insufficient stock for a product.
 */
public class InsufficientStockException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	/**
     * Constructs a new InsufficientStockException with the specified error message.
     *
     * @param message The error message.
     */
    public InsufficientStockException(String message) {
        super(message);
    }
}
