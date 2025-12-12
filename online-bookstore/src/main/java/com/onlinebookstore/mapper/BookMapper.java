package com.onlinebookstore.mapper;

import com.onlinebookstore.config.MapperConfig;
import com.onlinebookstore.dto.book.BookDto;
import com.onlinebookstore.dto.book.CreateBookRequestDto;
import com.onlinebookstore.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(config = MapperConfig.class, componentModel = "spring",
        uses = {GenreMapper.class, AuthorMapper.class})
public interface BookMapper {

    @Mapping(target = "publisherId", source = "publisher.id")
    @Mapping(target = "authorsIds", source = "authors", qualifiedByName = "mapAuthorsToIds")
    @Mapping(target = "genresIds", source = "genres", qualifiedByName = "mapGenresToIds")
    BookDto toDto(Book book);

    @Mapping(target = "authors", source = "authorsIds", qualifiedByName = "mapIdsToAuthors")
    @Mapping(target = "genres", source = "genresIds", qualifiedByName = "mapIdsToGenres")
    Book toModel(CreateBookRequestDto requestDto);

    // BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book);
    @Mapping(target = "authors", source = "authorsIds", qualifiedByName = "mapIdsToAuthors")
    @Mapping(target = "genres", source = "genresIds", qualifiedByName = "mapIdsToGenres")
    void updateModel(CreateBookRequestDto requestDto, @MappingTarget Book book);

    @Named("bookFromId")
    default Book bookFromId(Long id) {
        if (id == null) {
            return null;
        }
        Book book = new Book();
        book.setId(id);
        return book;
    }
}
