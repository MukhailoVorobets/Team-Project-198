package com.onlinebookstore.dto.book;

import java.math.BigDecimal;
import java.util.Set;

public record BookDto(
        String category,
        String slug,
        String title,
        Set<Long> authorsIds,
        BigDecimal fullPrice,
        BigDecimal price,
        BigDecimal rate,
        String age,
        Set<Long> genresIds,
        int year,
        String image,
        String isbn,
        String internalCode,
        Long publisherId,
        String series,
        String language,
        String coverType,
        boolean illustrations,
        int pages,
        String weight,
        boolean inStock,
        String description
) {
}
