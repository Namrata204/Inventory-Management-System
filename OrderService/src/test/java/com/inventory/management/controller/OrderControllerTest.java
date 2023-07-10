package com.inventory.management.controller;

import com.inventory.management.dto.OrderDto;
import com.inventory.management.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for the OrderController class.
 */
class OrderControllerTest {
    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for creating a new order successfully.
     */
    @Test
    void createOrder_ValidOrderDto_ReturnsCreatedOrderDto() {
        // Arrange
        OrderDto orderDto = new OrderDto();
        OrderDto createdOrderDto = new OrderDto();
        createdOrderDto.setId(1L);

        when(orderService.createOrder(orderDto)).thenReturn(createdOrderDto);

        // Act
        ResponseEntity<OrderDto> response = orderController.createOrder(orderDto);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(createdOrderDto, response.getBody());

        verify(orderService, times(1)).createOrder(orderDto);
    }

    /**
     * Test case for getting an existing order by ID.
     */
    @Test
    void getOrderById_ExistingOrderId_ReturnsOrderDto() {
        // Arrange
        Long orderId = 1L;
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderId);

        when(orderService.getOrderById(orderId)).thenReturn(orderDto);

        // Act
        ResponseEntity<OrderDto> response = orderController.getOrderById(orderId);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(orderDto, response.getBody());

        verify(orderService, times(1)).getOrderById(orderId);
    }

    /**
     * Test case for updating the status of an existing order.
     */
    @Test
    void updateOrderStatus_ExistingOrderIdAndValidStatus_ReturnsUpdatedOrderDto() {
        // Arrange
        Long orderId = 1L;
        String status = "Completed";
        OrderDto updatedOrderDto = new OrderDto();
        updatedOrderDto.setId(orderId);
        updatedOrderDto.setStatus(status);

        when(orderService.updateOrderStatus(orderId, status)).thenReturn(updatedOrderDto);

        // Act
        ResponseEntity<OrderDto> response = orderController.updateOrderStatus(orderId, status);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedOrderDto, response.getBody());

        verify(orderService, times(1)).updateOrderStatus(orderId, status);
    }

    /**
     * Test case for generating an invoice for an existing order.
     * Expects a byte array to be returned with HTTP status 200 (OK).
     */
    @Test
    void generateInvoice_ExistingOrderId_ReturnsInvoiceByteArray() {
        // Arrange
        Long orderId = 1L;
        byte[] invoice = {0x12, 0x34, 0x56};

        when(orderService.generateInvoice(orderId)).thenReturn(invoice);

        // Act
        ResponseEntity<byte[]> response = orderController.generateInvoice(orderId);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertArrayEquals(invoice, response.getBody());

        verify(orderService, times(1)).generateInvoice(orderId);
    }

    /**
     * Test case for generating an invoice for a nonexistent order.
     * Expects HTTP status 404 (Not Found).
     */
    @Test
    void generateInvoice_NonexistentOrderId_ReturnsNotFoundStatus() {
        // Arrange
        Long orderId = 1L;

        when(orderService.generateInvoice(orderId)).thenReturn(null);

        // Act
        ResponseEntity<byte[]> response = orderController.generateInvoice(orderId);

        // Assert
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());

        verify(orderService, times(1)).generateInvoice(orderId);
    }
}
