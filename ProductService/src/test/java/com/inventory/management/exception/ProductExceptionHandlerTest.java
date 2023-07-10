package com.inventory.management.exception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the {@link ProductExceptionHandler} class.
 */
class ProductExceptionHandlerTest {
    @InjectMocks
    private ProductExceptionHandler productExceptionHandler;

    @Mock
    private ProductNotFoundException productNotFoundException;

    @Mock
    private DuplicateProductException duplicateProductException;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for handling {@link ProductNotFoundException}.
     * Verifies that the appropriate error response with a "Not Found" status is returned.
     */
    @Test
    void handleProductNotFoundException_ReturnsErrorResponseWithNotFoundStatus() {
        // Arrange
        String errorMessage = "Product not found.";
        when(productNotFoundException.getMessage()).thenReturn(errorMessage);

        // Act
        ResponseEntity<ErrorResponse> response = productExceptionHandler.handleProductNotFoundException(productNotFoundException);
        ErrorResponse errorResponse = response.getBody();

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(HttpStatus.NOT_FOUND.value(), errorResponse.getStatus());
        assertEquals(errorMessage, errorResponse.getMessage());

        verify(productNotFoundException, times(1)).getMessage();
    }

    /**
     * Test case for handling {@link DuplicateProductException}.
     * Verifies that the appropriate error response with a "Conflict" status is returned.
     */
    @Test
    void handleDuplicateProductException_ReturnsErrorResponseWithConflictStatus() {
        // Arrange
        String errorMessage = "Duplicate product found.";
        when(duplicateProductException.getMessage()).thenReturn(errorMessage);

        // Act
        ResponseEntity<ErrorResponse> response = productExceptionHandler.handleDuplicateProductException(duplicateProductException);
        ErrorResponse errorResponse = response.getBody();

        // Assert
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertEquals(HttpStatus.CONFLICT.value(), errorResponse.getStatus());
        assertEquals(errorMessage, errorResponse.getMessage());
     

        verify(duplicateProductException, times(1)).getMessage();
    }

    /**
     * Test case for handling generic {@link Exception}.
     * Verifies that the appropriate error response with an "Internal Server Error" status is returned.
     */
    @Test
    void handleException_ReturnsErrorResponseWithInternalServerErrorStatus() {
        // Act
        ResponseEntity<ErrorResponse> response = productExceptionHandler.handleException(new Exception());
        ErrorResponse errorResponse = response.getBody();

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), errorResponse.getStatus());
        assertEquals("An error occurred", errorResponse.getMessage());
        
    }
}

