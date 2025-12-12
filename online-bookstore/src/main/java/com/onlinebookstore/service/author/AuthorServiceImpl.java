package com.onlinebookstore.service.author;

import com.onlinebookstore.dto.authors.AuthorResponseDto;
import com.onlinebookstore.dto.authors.CreateAuthorRequestDto;
import com.onlinebookstore.mapper.AuthorMapper;
import com.onlinebookstore.model.Author;
import com.onlinebookstore.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public AuthorResponseDto save(CreateAuthorRequestDto requestDto) {
        Author author = authorMapper.toModel(requestDto);
        return authorMapper.toDto(authorRepository.save(author));
    }

    @Override
    public List<AuthorResponseDto> findAll() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto findById(Long id) {
        return authorMapper.toDto(authorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Author not found")));
    }

    @Override
    public AuthorResponseDto update(Long authorId, CreateAuthorRequestDto requestDto) {
        Author author = authorRepository.findById(authorId).orElseThrow(
                () -> new RuntimeException("Author not found"));
        authorMapper.updateAuthor(requestDto, author);
        return authorMapper.toDto(authorRepository.save(author));
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Author not found"));
    }
}
