package com.onlinebookstore.mapper;

import com.onlinebookstore.config.MapperConfig;
import com.onlinebookstore.dto.caregory.CreateGenreRequestDto;
import com.onlinebookstore.dto.caregory.GenreResponseDto;
import com.onlinebookstore.model.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface GenreMapper {

    GenreResponseDto toDto(Genre genre);

    Genre toEntity(CreateGenreRequestDto requestDto);

    void updateModel(CreateGenreRequestDto requestDto, @MappingTarget Genre genre);

}
