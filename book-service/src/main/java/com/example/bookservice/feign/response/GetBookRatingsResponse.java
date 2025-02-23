package com.example.bookservice.feign.response;

import lombok.Builder;

import java.util.List;

@Builder
public record GetBookRatingsResponse(List<BookRating> bookRatings) {
}
