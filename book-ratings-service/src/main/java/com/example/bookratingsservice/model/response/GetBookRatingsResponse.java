package com.example.bookratingsservice.model.response;

import com.example.bookratingsservice.model.BookRating;
import lombok.Builder;

import java.util.List;

@Builder
public record GetBookRatingsResponse(List<BookRating> bookRatings) {
}
