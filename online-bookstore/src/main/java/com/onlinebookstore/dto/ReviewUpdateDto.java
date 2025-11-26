package com.onlinebookstore.dto;

import java.math.BigDecimal;

public record ReviewUpdateDto (
        BigDecimal rating,
        String comment
){
}
