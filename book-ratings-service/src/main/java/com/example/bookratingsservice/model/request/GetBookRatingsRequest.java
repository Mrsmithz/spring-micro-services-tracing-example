package com.example.bookratingsservice.model.request;

import lombok.Builder;

import java.util.List;

@Builder
public record GetBookRatingsRequest(List<Integer> bookIds) {
}
