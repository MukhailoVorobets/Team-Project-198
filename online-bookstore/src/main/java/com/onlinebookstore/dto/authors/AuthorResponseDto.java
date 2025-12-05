package com.onlinebookstore.dto.authors;

public record AuthorResponseDto(
        String name,
        String bio,
        String country
) {
}
