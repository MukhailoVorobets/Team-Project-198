package com.onlinebookstore.service.publisher;

import com.onlinebookstore.dto.publisher.CreatePublisherRequestDto;
import com.onlinebookstore.dto.publisher.PublisherDto;
import com.onlinebookstore.model.Publisher;
import java.util.List;

public interface PublisherService {
    PublisherDto save(CreatePublisherRequestDto requestDto);

    PublisherDto findById(Long id);

    List<PublisherDto> findAll();

    PublisherDto update(Long id, CreatePublisherRequestDto requestDto);

    void deleteById(Long id);

    Publisher getPublisherById(Long id);
}
