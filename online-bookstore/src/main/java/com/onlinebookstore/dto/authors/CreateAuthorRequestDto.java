package com.onlinebookstore.dto.authors;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAuthorRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String bio;

    @NotBlank
    private String country;
}
