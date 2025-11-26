package com.onlinebookstore.controller;

import com.onlinebookstore.dto.caregory.CategoryResponseDto;
import com.onlinebookstore.dto.caregory.CreateCategoryRequestDto;
import com.onlinebookstore.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponseDto createCategory(@RequestBody CreateCategoryRequestDto requestDto) {
        return categoryService.save(requestDto);
    }

    @GetMapping
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponseDto getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    @PutMapping("/{id}")
    public CategoryResponseDto  updateCategory(@PathVariable Long id,
                                               @RequestBody CreateCategoryRequestDto requestDto) {
        return categoryService.update(id, requestDto);
    }

    @DeleteMapping("{id}")
    public void deleteCategoryById(@PathVariable Long id) {
        categoryService.delete(id);
    }

//    @GetMapping("/{id}/books")
//    public Page<BookDtoWithoutCategoryIds> getBooksByCategoryId(@PathVariable Long id,
//                                                                Pageable pageable) {
//        return categoryService.getBooksByCategoryId(id, pageable);
//    }
}
