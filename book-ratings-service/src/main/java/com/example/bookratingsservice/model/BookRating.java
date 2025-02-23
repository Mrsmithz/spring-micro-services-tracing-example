package com.example.bookratingsservice.model;

import lombok.Builder;

@Builder
public record BookRating(Integer bookId, Double rating, String reviews) {
}
