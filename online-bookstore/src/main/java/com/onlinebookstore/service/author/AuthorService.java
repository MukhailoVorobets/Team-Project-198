package com.onlinebookstore.service.author;

import com.onlinebookstore.dto.authors.AuthorResponseDto;
import com.onlinebookstore.dto.authors.CreateAuthorRequestDto;

import java.util.List;

public interface AuthorService {
    AuthorResponseDto save(CreateAuthorRequestDto requestDto);
    List<AuthorResponseDto> findAll();
    AuthorResponseDto findById(Long id);
    AuthorResponseDto update(Long authorId,CreateAuthorRequestDto requestDto);
    void delete(Long id);
}
