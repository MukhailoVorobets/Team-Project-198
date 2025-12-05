package com.onlinebookstore.service;

import com.onlinebookstore.dto.CreateReviewRequestDto;
import com.onlinebookstore.dto.ReviewListDto;
import com.onlinebookstore.dto.ReviewResponseDto;
import com.onlinebookstore.dto.UpdateReviewRequestDto;
import com.onlinebookstore.mapper.ReviewMapper;
import com.onlinebookstore.model.Book;
import com.onlinebookstore.model.Review;
import com.onlinebookstore.model.User;
import com.onlinebookstore.repository.BookRepository;
import com.onlinebookstore.repository.ReviewRepository;
import com.onlinebookstore.repository.UserRepository;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Override
    public ReviewResponseDto save(Long userId, CreateReviewRequestDto requestDto) {
        Book book = bookRepository.findById(requestDto.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Review review = new Review();
        review.setBook(book);
        review.setUser(user);
        review.setRating(requestDto.getRating());
        review.setComment(requestDto.getComment());
        review.setDate(LocalDateTime.now());
        return reviewMapper.toDto(reviewRepository.save(review));
    }

    @Override
    public ReviewResponseDto findById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Review not found"));
        return reviewMapper.toDto(review);
    }

    @Override
    public List<ReviewListDto> findAll(Long bookId) {
        return reviewRepository.findAllByBookId(bookId).stream()
                .map(reviewMapper::toListDto)
                .toList();
    }

    @Override
    public ReviewResponseDto update(Long id, Long userId, UpdateReviewRequestDto requestDto) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        if (!review.getUser().getId().equals(userId)) {
            throw new RuntimeException("Access denied — only author can edit review");
        }

        if (requestDto.getRating() != null) {
            review.setRating(requestDto.getRating());
        }
        if (requestDto.getComment() != null) {
            review.setComment(requestDto.getComment());
        }
        return reviewMapper.toDto(reviewRepository.save(review));
    }

    @Override
    public void deleteById(Long id, Long userId) {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        if (!review.getUser().getId().equals(userId)) {
            throw new RuntimeException("Access denied — only author can delete review");
        }
        reviewRepository.deleteById(id);
    }
}
