package com.onlinebookstore.mapper;

import com.onlinebookstore.config.MapperConfig;
import com.onlinebookstore.dto.publisher.CreatePublisherRequestDto;
import com.onlinebookstore.dto.publisher.PublisherDto;
import com.onlinebookstore.model.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface PublisherMapper {

    PublisherDto toDto(Publisher publisher);

    Publisher toModel(CreatePublisherRequestDto requestDto);

    void updateModel(CreatePublisherRequestDto requestDto, @MappingTarget Publisher publisher);
}
