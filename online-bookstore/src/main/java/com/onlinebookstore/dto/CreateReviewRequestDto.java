package com.onlinebookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateReviewRequestDto {
    @NotNull
    @Positive
    private Long bookId;
    @NotNull
    @Positive
    private BigDecimal rating;
    @NotBlank
    private String comment;
}
