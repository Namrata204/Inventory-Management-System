package com.inventory.management.exception;


/**
 * Exception thrown when a we tries to add existing product.
 */
public class DuplicateProductException extends RuntimeException {

	 /**
     * Constructs a new DuplicateProductException with the specified error message.
     *
     * @param message The error message.
     */
	private static final long serialVersionUID = 1L;

	public DuplicateProductException(String message) {
        super(message);
    }
}

