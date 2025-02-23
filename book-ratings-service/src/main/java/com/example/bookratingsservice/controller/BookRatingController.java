package com.example.bookratingsservice.controller;

import com.example.bookratingsservice.model.request.GetBookRatingsRequest;
import com.example.bookratingsservice.model.response.GetBookRatingsResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/book-ratings")
public interface BookRatingController {

    @PostMapping
    GetBookRatingsResponse getBookRatings(@RequestBody GetBookRatingsRequest request);
}
