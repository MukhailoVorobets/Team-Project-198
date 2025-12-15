package com.onlinebookstore.controller;

import com.onlinebookstore.dto.order.CreateOrderRequestDto;
import com.onlinebookstore.dto.order.OrderItemsResponseDto;
import com.onlinebookstore.dto.order.OrderResponseDto;
import com.onlinebookstore.dto.order.UpdateOrderStatusRequestDto;
import com.onlinebookstore.model.User;
import com.onlinebookstore.service.order.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new order", description = "Create a new order")
    @PreAuthorize("hasRole('USER')")
    public OrderResponseDto createOrder(@RequestBody @Valid CreateOrderRequestDto requestDto,
                                        Authentication authentication) {
        Long userId = getCurrentUserId(authentication);
        return orderService.placeOrder(userId, requestDto);
    }

    @GetMapping
    @Operation(summary = "Get all orders", description = "Get a list of all orders")
    @PreAuthorize("hasRole('USER')")
    public Page<OrderResponseDto> getAll(Authentication authentication,
                                         Pageable pageable) {
        Long userId = getCurrentUserId(authentication);
        return orderService.getUserOrders(userId, pageable);
    }

    @GetMapping("/{orderId}/items")
    @Operation(summary = "Get all items from order", description = "Get all items from order")
    @PreAuthorize("hasRole('USER')")
    public Page<OrderItemsResponseDto> getOrderItems(@PathVariable Long orderId,
                                                     Authentication authentication,
                                                     Pageable pageable) {
        Long userId = getCurrentUserId(authentication);
        return orderService.getOrderItems(orderId, userId, pageable);
    }

    @GetMapping("/{orderId}/items/{itemId}")
    @Operation(summary = "Get book by id from order", description = "Get book by id from order")
    @PreAuthorize("hasRole('USER')")
    public OrderItemsResponseDto getSpecificOrderItem(@PathVariable Long orderId,
                                                      @PathVariable Long itemId,
                                                      Authentication authentication) {
        Long userId = getCurrentUserId(authentication);
        return orderService.getSpecificOrderItem(orderId, itemId, userId);
    }

    @PutMapping("/{orderId}")
    @Operation(summary = "Update order status", description = "Update order status")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderResponseDto updateStatus(@PathVariable Long orderId,
                                         @RequestBody @Valid UpdateOrderStatusRequestDto dto) {
        return orderService.updateOrderStatus(orderId,
                dto.status());
    }

    private Long getCurrentUserId(Authentication authentication) {
        return ((User) authentication.getPrincipal()).getId();
    }
}
