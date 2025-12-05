package com.onlinebookstore.mapper;

import com.onlinebookstore.config.MapperConfig;
import com.onlinebookstore.dto.ReviewListDto;
import com.onlinebookstore.dto.ReviewResponseDto;
import com.onlinebookstore.model.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MapperConfig.class, componentModel = "spring")
public interface ReviewMapper {
    //    Review toModel(CreateReviewRequestDto requestDto);

    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "user.id", target = "userId")
    ReviewResponseDto toDto(Review review);

    @Mapping(source = "user.firstName", target = "userName")
    ReviewListDto toListDto(Review review);

}
