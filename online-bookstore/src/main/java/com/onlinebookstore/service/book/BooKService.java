package com.onlinebookstore.service.book;

import com.onlinebookstore.dto.book.BookDto;
import com.onlinebookstore.dto.book.BookSearchParameters;
import com.onlinebookstore.dto.book.CreateBookRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BooKService {
    BookDto save(CreateBookRequestDto requestDto);

    Page<BookDto> findAll(Pageable pageable);

    BookDto getBookById(Long id);

    void deleteById(Long id);

    BookDto updateBookById(Long id, CreateBookRequestDto requestDto);

    Page<BookDto> search(BookSearchParameters searchParameters, Pageable pageable);
}
