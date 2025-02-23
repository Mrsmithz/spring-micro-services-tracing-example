package com.example.bookratingsservice.controller.implement;

import com.example.bookratingsservice.controller.BookRatingController;
import com.example.bookratingsservice.model.request.GetBookRatingsRequest;
import com.example.bookratingsservice.model.response.GetBookRatingsResponse;
import com.example.bookratingsservice.service.BookRatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookRatingControllerImpl implements BookRatingController {

    private final BookRatingService bookRatingService;

    @Override
    public GetBookRatingsResponse getBookRatings(GetBookRatingsRequest request) {
        return bookRatingService.getBookRatings(request);
    }
}
