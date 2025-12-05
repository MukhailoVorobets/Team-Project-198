package com.onlinebookstore.mapper;

import com.onlinebookstore.config.MapperConfig;
import com.onlinebookstore.dto.authors.AuthorResponseDto;
import com.onlinebookstore.dto.authors.CreateAuthorRequestDto;
import com.onlinebookstore.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface AuthorMapper {

    Author toModel(CreateAuthorRequestDto requestDto);

    AuthorResponseDto toDto(Author author);

    void updateAuthor(CreateAuthorRequestDto requestDto, @MappingTarget Author author);
}

