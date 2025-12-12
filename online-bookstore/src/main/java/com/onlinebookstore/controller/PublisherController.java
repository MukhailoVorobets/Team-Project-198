package com.onlinebookstore.controller;

import com.onlinebookstore.dto.publisher.CreatePublisherRequestDto;
import com.onlinebookstore.dto.publisher.PublisherDto;
import com.onlinebookstore.service.publisher.PublisherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Publisher management", description = "Endpoint for managing publisher")
@RestController
@RequestMapping("/books/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @Operation(summary = "Create a new publisher", description = "Create a new publisher")
    @PostMapping
    public PublisherDto createPublisher(@RequestBody CreatePublisherRequestDto requestDto) {
        return publisherService.save(requestDto);
    }

    @Operation(summary = "Get all publisher", description = "Get a list of all publisher")
    @GetMapping
    public Page<PublisherDto> getAllPublisher(Pageable pageable) {
        return publisherService.findAll(pageable);
    }

    @Operation(summary = "Get publisher by id", description = "Get publisher by id")
    @GetMapping("/{id}")
    public PublisherDto getPublisherById(@PathVariable Long id) {
        return publisherService.findById(id);
    }

    @Operation(summary = "Update publisher by id", description = "Update publisher by id")
    @PutMapping("/{id}")
    public PublisherDto updatePublisher(@PathVariable Long id,
                                        @RequestBody CreatePublisherRequestDto requestDto) {
        return publisherService.update(id, requestDto);
    }

    @Operation(summary = "Delete publisher", description = "Delete publisher")
    @DeleteMapping("{id}")
    public void deletePublisherById(@PathVariable Long id) {
        publisherService.deleteById(id);
    }
}
