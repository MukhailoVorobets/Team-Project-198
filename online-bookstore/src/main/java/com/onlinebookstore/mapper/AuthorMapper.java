package com.onlinebookstore.mapper;

import com.onlinebookstore.config.MapperConfig;
import com.onlinebookstore.dto.authors.AuthorResponseDto;
import com.onlinebookstore.dto.authors.CreateAuthorRequestDto;
import com.onlinebookstore.model.Author;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface AuthorMapper {

    Author toModel(CreateAuthorRequestDto requestDto);

    AuthorResponseDto toDto(Author author);

    void updateAuthor(CreateAuthorRequestDto requestDto, @MappingTarget Author author);

    @Named("mapIdsToAuthors")
    default Set<Author> mapIdsToAuthors(Set<Long> ids) {
        if (ids == null) {
            return null;
        }
        return ids.stream().map(id -> {
            Author author = new Author();
            author.setId(id);
            return author;
        }).collect(Collectors.toSet());
    }

    @Named("mapAuthorsToIds")
    default Set<Long> mapAuthorsToIds(Set<Author> authors) {
        if (authors == null) {
            return null;
        }
        return authors.stream()
                .map(Author::getId)
                .collect(Collectors.toSet());
    }
}

