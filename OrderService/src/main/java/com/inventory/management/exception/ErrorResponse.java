package com.inventory.management.exception;

public class ErrorResponse {
    private int status;
    private String message;
    private long timestamp;
    
    /**
     * Retrieves the status code of the error response.
     *
     * @return The status code.
     */
    public int getStatus() {
        return status;
    }
    
    /**
     * Sets the status code of the error response.
     *
     * @param status The status code to set.
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    /**
     * Retrieves the error message of the error response.
     *
     * @return The error message.
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Sets the error message of the error response.
     *
     * @param message The error message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Retrieves the timestamp of the error response.
     *
     * @return The timestamp.
     */
    public long getTimestamp() {
        return timestamp;
    }
    
    /**
     * Sets the timestamp of the error response.
     *
     * @param timestamp The timestamp to set.
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    /**
     * Constructs a new ErrorResponse object with the specified status, message, and timestamp.
     *
     * @param status    The status code of the error response.
     * @param message   The error message of the error response.
     * @param timestamp The timestamp of the error response.
     */
    public ErrorResponse(int status, String message, long timestamp) {
        super();
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
    
    /**
     * Constructs a new empty ErrorResponse object.
     */
    public ErrorResponse() {
        super();
    }
}

