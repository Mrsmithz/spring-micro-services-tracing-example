package com.example.bookratingsservice.service;

import com.example.bookratingsservice.model.request.GetBookRatingsRequest;
import com.example.bookratingsservice.model.response.GetBookRatingsResponse;

public interface BookRatingService {

    GetBookRatingsResponse getBookRatings(GetBookRatingsRequest request);
}
