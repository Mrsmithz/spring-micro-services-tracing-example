package com.example.bookinfoservice.model.request;

import lombok.Builder;

import java.util.List;

@Builder
public record GetBooksInfoRequest(List<Integer> bookIds) {
}
