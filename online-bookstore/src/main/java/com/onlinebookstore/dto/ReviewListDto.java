package com.onlinebookstore.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReviewListDto(
        Long id,
        BigDecimal rating,
        String comment,
        String userName,
        LocalDateTime date
) {
}
