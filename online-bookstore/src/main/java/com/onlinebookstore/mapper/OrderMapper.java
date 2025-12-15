package com.onlinebookstore.mapper;

import com.onlinebookstore.config.MapperConfig;
import com.onlinebookstore.dto.order.OrderItemsResponseDto;
import com.onlinebookstore.dto.order.OrderResponseDto;
import com.onlinebookstore.model.Order;
import com.onlinebookstore.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class)
public interface OrderMapper {
    @Mapping(source = "user.id", target = "userId")
    OrderResponseDto toDto(Order order);

    @Mapping(source = "book.id", target = "bookId")
    OrderItemsResponseDto toItemDto(OrderItem item);
}
