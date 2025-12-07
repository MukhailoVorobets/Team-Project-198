package com.onlinebookstore.service.category;

import com.onlinebookstore.dto.caregory.CreateGenreRequestDto;
import com.onlinebookstore.dto.caregory.GenreResponseDto;
import com.onlinebookstore.mapper.GenreMapper;
import com.onlinebookstore.model.Genre;
import com.onlinebookstore.repository.GenreRepository;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public GenreResponseDto save(CreateGenreRequestDto requestDto) {
        Genre genre = genreMapper.toEntity(requestDto);
        return genreMapper.toDto(genreRepository.save(genre));
    }

    @Override
    public GenreResponseDto getById(Long id) {
        return genreMapper.toDto(genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genre not found")));
    }

    @Override
    public List<GenreResponseDto> findAll() {
        return genreRepository.findAll().stream()
                .map(genreMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public GenreResponseDto update(Long id, CreateGenreRequestDto requestDto) {
        Genre category = genreRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genre not found"));
        genreMapper.updateModel(requestDto, category);
        return genreMapper.toDto(genreRepository.save(category));
    }

    @Override
    public void delete(Long id) {
        genreRepository.deleteById(id);
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }
}
