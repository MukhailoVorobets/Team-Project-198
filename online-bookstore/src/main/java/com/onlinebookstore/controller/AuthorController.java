package com.onlinebookstore.controller;

import com.onlinebookstore.dto.authors.AuthorResponseDto;
import com.onlinebookstore.dto.authors.CreateAuthorRequestDto;
import com.onlinebookstore.service.author.AuthorService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    //    GET /api/authors
    //    Отримати список авторів

    @GetMapping
    public List<AuthorResponseDto> getAuthors() {
        return authorService.findAll();
    }

    //    GET /api/authors/{id}
    //    Отримати автора за ID
    @GetMapping("/{id}")
    public AuthorResponseDto getAuthor(@PathVariable Long id) {
        return authorService.findById(id);
    }

    //    POST /api/authors
    //    Створити автора
    @PostMapping
    public AuthorResponseDto createAuthor(@RequestBody CreateAuthorRequestDto requestDto) {
        return authorService.save(requestDto);
    }

    //    PUT /api/authors/{id}
    //    Оновити автора
    @PostMapping("{id}")
    public AuthorResponseDto updateAuthor(@PathVariable Long id,
                                          @RequestBody CreateAuthorRequestDto requestDto) {
        return authorService.update(id, requestDto);
    }

    //    DELETE /api/authors/{id}
    //    Видалити автора
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
    }

    //    @GetMapping("/{id}/books")
    //    public Page<BookDtoWithoutCategoryIds> getBooksByAuthorId(@PathVariable Long id,
    //                                                                Pageable pageable) {
    //        return authorService.getBooksByAuthorsId(id, pageable);
    //    }
}
