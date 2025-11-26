package com.onlinebookstore.mapper;

import com.onlinebookstore.config.MapperConfig;
import com.onlinebookstore.dto.caregory.CategoryResponseDto;
import com.onlinebookstore.dto.caregory.CreateCategoryRequestDto;
import com.onlinebookstore.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface CategoryMapper {

    CategoryResponseDto toDto(Category category);

    Category toEntity(CreateCategoryRequestDto requestDto);

    void updateModel(CreateCategoryRequestDto requestDto, @MappingTarget Category category);

}
