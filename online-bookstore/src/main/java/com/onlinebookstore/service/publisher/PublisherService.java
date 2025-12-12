package com.onlinebookstore.service.publisher;

import com.onlinebookstore.dto.publisher.CreatePublisherRequestDto;
import com.onlinebookstore.dto.publisher.PublisherDto;
import com.onlinebookstore.model.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PublisherService {
    PublisherDto save(CreatePublisherRequestDto requestDto);

    PublisherDto findById(Long id);

    Page<PublisherDto> findAll(Pageable pageable);

    PublisherDto update(Long id, CreatePublisherRequestDto requestDto);

    void deleteById(Long id);

    Publisher getPublisherById(Long id);
}
