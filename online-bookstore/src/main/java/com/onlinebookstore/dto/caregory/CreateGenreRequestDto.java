package com.onlinebookstore.dto.caregory;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateGenreRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String sub;

}
