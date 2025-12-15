package com.onlinebookstore.dto.order;

import com.onlinebookstore.model.Order;
import lombok.NonNull;

public record UpdateOrderStatusRequestDto(
        @NonNull
        Order.Status status
) {
}
