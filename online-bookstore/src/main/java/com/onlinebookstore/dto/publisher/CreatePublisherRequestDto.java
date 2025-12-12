package com.onlinebookstore.dto.publisher;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreatePublisherRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
