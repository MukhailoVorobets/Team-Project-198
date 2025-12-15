package com.onlinebookstore.controller;

import com.onlinebookstore.dto.CreateReviewRequestDto;
import com.onlinebookstore.dto.ReviewListDto;
import com.onlinebookstore.dto.ReviewResponseDto;
import com.onlinebookstore.dto.UpdateReviewRequestDto;
import com.onlinebookstore.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Review management", description = "Endpoint for managing review")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books/{id}")
public class ReviewController {
    private final ReviewService reviewService;

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get all reviews", description = "Get a list of reviews")
    @GetMapping("/reviews")
    public List<ReviewListDto> getReviews(@PathVariable Long id) {
        return reviewService.findAll(id);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Create review", description = "Create review")
    @PostMapping("/reviews")
    public ReviewResponseDto createReview(@PathVariable Long id,
                                          @RequestBody CreateReviewRequestDto review) {
        return reviewService.save(id, review);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Update review", description = "Update review")
    @PostMapping
    public ReviewResponseDto updateReview(@PathVariable Long id,
                               @RequestBody UpdateReviewRequestDto requestDto,
                               @RequestAttribute Long userId) {
        return reviewService.update(id, userId, requestDto);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Delete review", description = "Delete review")
    @DeleteMapping
    public void deleteReview(@PathVariable Long id,
                             @RequestAttribute Long userId) {
        reviewService.deleteById(id, userId);
    }
}
