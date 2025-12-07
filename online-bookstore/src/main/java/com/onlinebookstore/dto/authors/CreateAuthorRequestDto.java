package com.onlinebookstore.dto.authors;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAuthorRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String image;

    @NotBlank
    private String description;
}
