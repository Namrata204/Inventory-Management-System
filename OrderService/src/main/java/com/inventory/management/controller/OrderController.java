package com.inventory.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.dto.OrderDto;
import com.inventory.management.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * Create a new order.
     *
     * @param orderDto The order data.
     * @return The created order and HTTP status 201 (Created) if successful.
     */
    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderDto createdOrder = orderService.createOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    /**
     * Get an order by ID.
     *
     * @param orderId The ID of the order.
     * @return The order and HTTP status 200 (OK) if found,
     *         or HTTP status 404 (Not Found) if the order does not exist.
     */
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long orderId) {
        OrderDto orderDto = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orderDto);
    }

    /**
     * Update the status of an order.
     *
     * @param orderId The ID of the order.
     * @param status  The new status of the order.
     * @return The updated order and HTTP status 200 (OK) if successful,
     *         or HTTP status 404 (Not Found) if the order does not exist.
     */
    @PutMapping("/{orderId}/status")
    public ResponseEntity<OrderDto> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status
    ) {
        OrderDto updatedOrder = orderService.updateOrderStatus(orderId, status);
        return ResponseEntity.ok(updatedOrder);
    }

    /**
     * Generate an invoice for an order.
     *
     * @param orderId The ID of the order.
     * @return The invoice file as a byte array and HTTP status 200 (OK) if successful,
     *         or HTTP status 404 (Not Found) if the order does not exist.
     */
    @GetMapping("/{orderId}/invoice")
    public ResponseEntity<byte[]> generateInvoice(@PathVariable Long orderId) {
        byte[] invoice = orderService.generateInvoice(orderId);
        if (invoice != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "invoice.pdf");
            return ResponseEntity.ok().headers(headers).body(invoice);
        }
        return ResponseEntity.notFound().build();
    }
}

