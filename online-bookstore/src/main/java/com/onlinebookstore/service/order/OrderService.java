package com.onlinebookstore.service.order;

import com.onlinebookstore.dto.order.CreateOrderRequestDto;
import com.onlinebookstore.dto.order.OrderItemsResponseDto;
import com.onlinebookstore.dto.order.OrderResponseDto;
import com.onlinebookstore.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    OrderResponseDto placeOrder(Long userId, CreateOrderRequestDto requestDto);

    Page<OrderResponseDto> getUserOrders(Long userId, Pageable pageable);

    Page<OrderItemsResponseDto> getOrderItems(Long orderId, Long userId, Pageable pageable);

    OrderItemsResponseDto getSpecificOrderItem(Long orderId, Long itemId, Long userId);

    OrderResponseDto updateOrderStatus(Long orderId, Order.Status status);
}
