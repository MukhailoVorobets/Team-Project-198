package com.onlinebookstore.mapper;

import com.onlinebookstore.config.MapperConfig;
import com.onlinebookstore.dto.caregory.CreateGenreRequestDto;
import com.onlinebookstore.dto.caregory.GenreResponseDto;
import com.onlinebookstore.model.Genre;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface GenreMapper {

    GenreResponseDto toDto(Genre genre);

    Genre toEntity(CreateGenreRequestDto requestDto);

    void updateModel(CreateGenreRequestDto requestDto, @MappingTarget Genre genre);

    @Named("mapIdsToGenres")
    default Set<Genre> mapIdsToGenres(Set<Long> ids) {
        if (ids == null) {
            return null;
        }
        return ids.stream().map(id -> {
            Genre genre = new Genre();
            genre.setId(id);
            return genre;
        }).collect(Collectors.toSet());
    }

    @Named("mapGenresToIds")
    default Set<Long> mapGenresToIds(Set<Genre> genres) {
        if (genres == null) {
            return null;
        }
        return genres.stream()
                .map(Genre::getId)
                .collect(Collectors.toSet());
    }
}
