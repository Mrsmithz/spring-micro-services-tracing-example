package com.example.bookservice.feign.request;

import lombok.Builder;

import java.util.List;

@Builder
public record GetBooksInfoRequest(List<Integer> bookIds) {
}
