package com.example.bookratingsservice.service.implement;

import com.example.bookratingsservice.model.BookRating;
import com.example.bookratingsservice.model.request.GetBookRatingsRequest;
import com.example.bookratingsservice.model.response.GetBookRatingsResponse;
import com.example.bookratingsservice.repository.BookRatingRepository;
import com.example.bookratingsservice.service.BookRatingService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookRatingServiceImpl implements BookRatingService {

    private final Random random = new Random();
    private final BookRatingRepository bookRatingRepository;

    @Override
    @SneakyThrows
    public GetBookRatingsResponse getBookRatings(GetBookRatingsRequest request) {
        boolean isEven = request.bookIds()
                .stream()
                .anyMatch(id -> id % 2 == 0);

        Thread.sleep(random.nextInt(10, 5000));

        return GetBookRatingsResponse.builder()
                .bookRatings(bookRatingRepository.findAll()
                        .stream()
                        .peek(bookRating -> log.info("book rating: {}", bookRating))
                        .filter(bookRating -> isEven)
                        .map(bookRating -> BookRating.builder()
                                .bookId(bookRating.getBookId())
                                .rating(bookRating.getRating())
                                .reviews(bookRating.getReviews())
                                .build())
                        .toList())
                .build();
    }
}
