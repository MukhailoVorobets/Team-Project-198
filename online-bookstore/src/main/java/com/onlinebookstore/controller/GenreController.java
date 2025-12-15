package com.onlinebookstore.controller;

import com.onlinebookstore.dto.caregory.CreateGenreRequestDto;
import com.onlinebookstore.dto.caregory.GenreResponseDto;
import com.onlinebookstore.service.category.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Genre management", description = "Endpoint for managing genre")
@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a new genre", description = "Create a new genre")
    @PostMapping
    public GenreResponseDto createGenre(@RequestBody CreateGenreRequestDto requestDto) {
        return genreService.save(requestDto);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get all genres", description = "Get a list of all genres")
    @GetMapping
    public Page<GenreResponseDto> getAllGenres(Pageable pageable) {
        return genreService.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get genre by id", description = "Get genre by id")
    @GetMapping("/{id}")
    public GenreResponseDto getGenreById(@PathVariable Long id) {
        return genreService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update genre", description = "Update genre")
    @PutMapping("/{id}")
    public GenreResponseDto updateGenre(@PathVariable Long id,
                                           @RequestBody CreateGenreRequestDto requestDto) {
        return genreService.update(id, requestDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete genre", description = "Delete genre")
    @DeleteMapping("{id}")
    public void deleteGenreById(@PathVariable Long id) {
        genreService.delete(id);
    }

    //    @GetMapping("/{id}/books")
    //    public Page<BookDtoWithoutCategoryIds> getBooksByCategoryId(@PathVariable Long id,
    //                                                                Pageable pageable) {
    //        return categoryService.getBooksByCategoryId(id, pageable);
    //    }
}
