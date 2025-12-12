package com.onlinebookstore.dto.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotBlank
    private String category;

    @NotBlank
    private String slug;

    @NotBlank
    private String title;

    @NotEmpty
    private Set<Long> authorsIds;

    @NotNull
    @Positive
    private BigDecimal fullPrice;

    @NotNull
    @Positive
    private BigDecimal price;

    @Positive
    private BigDecimal rate;

    @NotBlank
    private String age;

    @NotEmpty
    private Set<Long> genresIds;

    @NotNull
    @Positive
    private int year;

    @NotBlank
    private String image;

    @NotBlank
    private String isbn;

    @NotBlank
    private String internalCode;

    @NotNull
    private Long publisherId;

    @NotBlank
    private String series;

    @NotBlank
    private String language;

    @NotBlank
    private String coverType;

    private boolean illustrations;

    @Positive
    @NotNull
    private int pages;

    @NotBlank
    private String weight;

    private boolean inStock;

    @Size(max = 1000)
    private String description;
}
