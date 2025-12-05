package com.onlinebookstore.controller;

import com.onlinebookstore.dto.CreateReviewRequestDto;
import com.onlinebookstore.dto.ReviewListDto;
import com.onlinebookstore.dto.ReviewResponseDto;
import com.onlinebookstore.dto.UpdateReviewRequestDto;
import com.onlinebookstore.service.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books/{id}")
public class ReviewController {
    private final ReviewService reviewService;

    //    GET /api/books/{id}/reviews
    @GetMapping("/reviews")
    public List<ReviewListDto> getReviews(@PathVariable Long id) {
        return reviewService.findAll(id);
    }

    //    POST /api/books/{id}/reviews
    @PostMapping("/reviews")
    public ReviewResponseDto createReview(@PathVariable Long id,
                                          @RequestBody CreateReviewRequestDto review) {
        return reviewService.save(id, review);
    }

    //    PUT /api/reviews/{id}
    @PostMapping
    public ReviewResponseDto updateReview(@PathVariable Long id,
                               @RequestBody UpdateReviewRequestDto requestDto,
                               @RequestAttribute Long userId) {
        return reviewService.update(id, userId, requestDto);
    }

    //    DELETE /api/reviews/{id}
    @DeleteMapping
    public void deleteReview(@PathVariable Long id,
                             @RequestAttribute Long userId) {
        reviewService.deleteById(id, userId);
    }
}
