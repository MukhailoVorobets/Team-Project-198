package com.onlinebookstore.service.book;

import com.onlinebookstore.dto.book.BookDto;
import com.onlinebookstore.dto.book.BookSearchParameters;
import com.onlinebookstore.dto.book.CreateBookRequestDto;
import com.onlinebookstore.exception.EntityNotFoundException;
import com.onlinebookstore.mapper.BookMapper;
import com.onlinebookstore.model.Author;
import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.Genre;
import com.onlinebookstore.repository.book.BookRepository;
import com.onlinebookstore.repository.book.BookSpecificationBuilder;
import com.onlinebookstore.service.author.AuthorService;
import com.onlinebookstore.service.category.GenreService;
import com.onlinebookstore.service.publisher.PublisherService;
import jakarta.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class BooKServiceImpl implements BooKService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final BookSpecificationBuilder bookSpecificationBuilder;
    private final GenreService genreService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        if (requestDto.getGenresIds() != null) {
            Set<Genre> genres = requestDto.getGenresIds().stream()
                    .map(genreService::getGenreById)
                    .collect(Collectors.toSet());
            book.setGenres(genres);
        }
        if (requestDto.getAuthorsIds() != null) {
            Set<Author> authors = requestDto.getAuthorsIds().stream()
                    .map(authorService::getAuthorById)
                    .collect(Collectors.toSet());
            book.setAuthors(authors);
        }
        if (requestDto.getPublisherId() != null) {
            book.setPublisher(publisherService.getPublisherById(requestDto.getPublisherId()));
        }

        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public Page<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::toDto);
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't not find book by id " + id));
        return bookMapper.toDto(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBookById(Long id, CreateBookRequestDto requestDto) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't not find book by id " + id));
        bookMapper.updateModel(requestDto, book);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public Page<BookDto> search(BookSearchParameters searchParameters, Pageable pageable) {
        Specification<Book> specification = bookSpecificationBuilder.build(searchParameters);
        return bookRepository.findAll(specification, pageable)
                .map(bookMapper::toDto);
    }
}
