package com.onlinebookstore.controller;

import com.onlinebookstore.dto.authors.AuthorResponseDto;
import com.onlinebookstore.dto.authors.CreateAuthorRequestDto;
import com.onlinebookstore.service.author.AuthorService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Author management", description = "Endpoint for managing authors")
@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @Operation(summary = "Get all authors", description = "Get a list of all authors")
    @GetMapping
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public Page<AuthorResponseDto> getAuthors(Pageable pageable) {
        return authorService.findAll(pageable);
    }

    @Operation(summary = "Get author by id", description = "Get author by id")
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public AuthorResponseDto getAuthor(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @Operation(summary = "Create new author", description = "Create new author")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public AuthorResponseDto createAuthor(@RequestBody CreateAuthorRequestDto requestDto) {
        return authorService.save(requestDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update author", description = "Update author")
    @PostMapping("{id}")
    public AuthorResponseDto updateAuthor(@PathVariable Long id,
                                          @RequestBody CreateAuthorRequestDto requestDto) {
        return authorService.update(id, requestDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete author", description = "Delete author")
    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.delete(id);
    }

    //    @GetMapping("/{id}/books")
    //    public Page<BookDtoWithoutGenreIds> getBooksByAuthorId(@PathVariable Long id,
    //                                                           Pageable pageable) {
    //        return authorService.getBooksByAuthorsId(id, pageable);
    //    }
}
