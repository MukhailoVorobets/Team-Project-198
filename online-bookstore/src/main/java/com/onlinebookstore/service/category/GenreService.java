package com.onlinebookstore.service.category;

import com.onlinebookstore.dto.caregory.CreateGenreRequestDto;
import com.onlinebookstore.dto.caregory.GenreResponseDto;
import com.onlinebookstore.model.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GenreService {

    GenreResponseDto save(CreateGenreRequestDto requestDto);

    GenreResponseDto getById(Long id);

    Page<GenreResponseDto> findAll(Pageable pageable);

    GenreResponseDto update(Long id, CreateGenreRequestDto requestDto);

    //    Page<BookDtoWithoutCategoryIds> getBooksByGenreId(Long id, Pageable pageable);

    void delete(Long id);

    Genre getGenreById(Long id);
}
