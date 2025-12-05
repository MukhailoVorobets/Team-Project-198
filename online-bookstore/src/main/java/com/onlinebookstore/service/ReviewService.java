package com.onlinebookstore.service;

import com.onlinebookstore.dto.CreateReviewRequestDto;
import com.onlinebookstore.dto.ReviewListDto;
import com.onlinebookstore.dto.ReviewResponseDto;
import com.onlinebookstore.dto.UpdateReviewRequestDto;
import java.util.List;

public interface ReviewService {

    ReviewResponseDto save(Long userId, CreateReviewRequestDto requestDto);

    ReviewResponseDto findById(Long id);

    List<ReviewListDto> findAll(Long bookId);

    ReviewResponseDto update(Long id, Long userId, UpdateReviewRequestDto requestDto);

    void deleteById(Long id, Long userId);
}
