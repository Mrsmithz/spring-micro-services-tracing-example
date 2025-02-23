package com.example.bookservice.feign.response;

import lombok.Builder;

@Builder
public record BookRating(Integer bookId, Double rating, String reviews) {
}
