package com.example.bookservice.feign.request;

import lombok.Builder;

import java.util.List;

@Builder
public record GetBookRatingsRequest(List<Integer> bookIds) {
}
