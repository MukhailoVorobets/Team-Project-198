package com.onlinebookstore.dto.authors;

public record AuthorResponseDto(
        String name,
        String image,
        String description
) {
}
