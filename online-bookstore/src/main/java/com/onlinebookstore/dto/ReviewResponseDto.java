package com.onlinebookstore.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ReviewResponseDto(
         Long id,
         Long bookId,
         Long userId,
         BigDecimal rating,
         String comment,
         LocalDateTime date
) {
}
