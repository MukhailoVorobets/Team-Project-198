package com.onlinebookstore.service.category;

import com.onlinebookstore.dto.caregory.CategoryResponseDto;
import com.onlinebookstore.dto.caregory.CreateCategoryRequestDto;
import com.onlinebookstore.model.Category;

import java.util.List;

public interface CategoryService {
    CategoryResponseDto save(CreateCategoryRequestDto requestDto);
    CategoryResponseDto getById(Long id);
    List<CategoryResponseDto> findAll();
    CategoryResponseDto update(Long id, CreateCategoryRequestDto requestDto);
//    Page<BookDtoWithoutCategoryIds> getBooksByCategoryId(Long id, Pageable pageable);
    void delete(Long id);
    Category getCategoryById(Long id);
}
