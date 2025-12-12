package com.onlinebookstore.service.author;

import com.onlinebookstore.dto.authors.AuthorResponseDto;
import com.onlinebookstore.dto.authors.CreateAuthorRequestDto;
import com.onlinebookstore.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AuthorService {

    AuthorResponseDto save(CreateAuthorRequestDto requestDto);

    Page<AuthorResponseDto> findAll(Pageable pageable);

    AuthorResponseDto findById(Long id);

    AuthorResponseDto update(Long authorId,CreateAuthorRequestDto requestDto);

    void delete(Long id);

    Author getAuthorById(Long id);
}
