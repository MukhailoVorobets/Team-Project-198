package com.onlinebookstore.controller;

import com.onlinebookstore.dto.caregory.CreateGenreRequestDto;
import com.onlinebookstore.dto.caregory.GenreResponseDto;
import com.onlinebookstore.service.category.GenreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping
    public GenreResponseDto createGenre(@RequestBody CreateGenreRequestDto requestDto) {
        return genreService.save(requestDto);
    }

    @GetMapping
    public List<GenreResponseDto> getAllGenres() {
        return genreService.findAll();
    }

    @GetMapping("/{id}")
    public GenreResponseDto getGenreById(@PathVariable Long id) {
        return genreService.getById(id);
    }

    @PutMapping("/{id}")
    public GenreResponseDto updateGenre(@PathVariable Long id,
                                           @RequestBody CreateGenreRequestDto requestDto) {
        return genreService.update(id, requestDto);
    }

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
