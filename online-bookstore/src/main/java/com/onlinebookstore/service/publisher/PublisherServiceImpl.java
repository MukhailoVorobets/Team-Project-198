package com.onlinebookstore.service.publisher;

import com.onlinebookstore.dto.publisher.CreatePublisherRequestDto;
import com.onlinebookstore.dto.publisher.PublisherDto;
import com.onlinebookstore.exception.EntityNotFoundException;
import com.onlinebookstore.mapper.PublisherMapper;
import com.onlinebookstore.model.Publisher;
import com.onlinebookstore.repository.PublisherRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PublisherServiceImpl implements PublisherService {
    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    @Override
    public PublisherDto save(CreatePublisherRequestDto requestDto) {
        Publisher publisher = publisherMapper.toModel(requestDto);
        return publisherMapper.toDto(publisherRepository.save(publisher));
    }

    @Override
    public PublisherDto findById(Long id) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Publisher with id " + id + " not found"));
        return publisherMapper.toDto(publisher);
    }

    @Override
    public List<PublisherDto> findAll() {
        return publisherRepository.findAll().stream()
                .map(publisherMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PublisherDto update(Long id, CreatePublisherRequestDto requestDto) {
        Publisher publisher = publisherRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Publisher with id " + id + " not found"));
        publisherMapper.updateModel(requestDto, publisher);
        return publisherMapper.toDto(publisherRepository.save(publisher));
    }

    @Override
    public void deleteById(Long id) {
        publisherRepository.deleteById(id);
    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Publisher with id " + id + " not found"));
    }
}
