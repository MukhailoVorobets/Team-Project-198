package com.onlinebookstore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

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
