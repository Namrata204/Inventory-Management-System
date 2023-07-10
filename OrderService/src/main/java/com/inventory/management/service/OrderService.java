package com.inventory.management.service;

import com.inventory.management.dto.OrderDto;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto);

    OrderDto getOrderById(Long orderId);

    OrderDto updateOrderStatus(Long orderId, String status);

    byte[] generateInvoice(Long orderId);
}

