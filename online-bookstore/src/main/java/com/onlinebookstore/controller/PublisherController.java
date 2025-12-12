package com.onlinebookstore.controller;

import com.onlinebookstore.dto.publisher.CreatePublisherRequestDto;
import com.onlinebookstore.dto.publisher.PublisherDto;
import com.onlinebookstore.service.publisher.PublisherService;
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
@RequestMapping("/books/publishers")
@RequiredArgsConstructor
public class PublisherController {
    private final PublisherService publisherService;

    @PostMapping
    public PublisherDto createPublisher(@RequestBody CreatePublisherRequestDto requestDto) {
        return publisherService.save(requestDto);
    }

    @GetMapping
    public List<PublisherDto> getAllPublisher() {
        return publisherService.findAll();
    }

    @GetMapping("/{id}")
    public PublisherDto getPublisherById(@PathVariable Long id) {
        return publisherService.findById(id);
    }

    @PutMapping("/{id}")
    public PublisherDto updatePublisher(@PathVariable Long id,
                                        @RequestBody CreatePublisherRequestDto requestDto) {
        return publisherService.update(id, requestDto);
    }

    @DeleteMapping("{id}")
    public void deletePublisherById(@PathVariable Long id) {
        publisherService.deleteById(id);
    }
}
