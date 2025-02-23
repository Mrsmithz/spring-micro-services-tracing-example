package com.example.bookservice.service.implement;

import com.example.bookservice.feign.BookInfoServiceFeign;
import com.example.bookservice.feign.BookRatingServiceFeign;
import com.example.bookservice.feign.request.GetBookRatingsRequest;
import com.example.bookservice.feign.request.GetBooksInfoRequest;
import com.example.bookservice.feign.response.BookRating;
import com.example.bookservice.feign.response.GetBookRatingsResponse;
import com.example.bookservice.feign.response.GetBooksInfoResponse;
import com.example.bookservice.model.Book;
import com.example.bookservice.model.response.GetAllBooksResponse;
import com.example.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final Random random = new Random();
    private final HttpHeaders httpHeaders;
    private final BookInfoServiceFeign bookInfoServiceFeign;
    private final BookRatingServiceFeign bookRatingServiceFeign;

    @Override
    public GetAllBooksResponse getAllBooks() {
        List<Integer> bookIds = random.ints(20, 1, 100)
                .boxed()
                .toList();

        GetBooksInfoRequest booksInfoRequest = GetBooksInfoRequest.builder()
                .bookIds(bookIds)
                .build();
        GetBooksInfoResponse response = bookInfoServiceFeign.getBooksInfo(httpHeaders, booksInfoRequest);

        GetBookRatingsRequest bookRatingsRequest = GetBookRatingsRequest.builder()
                .bookIds(bookIds)
                .build();
        GetBookRatingsResponse bookRatingsResponse = bookRatingServiceFeign.getBookRatings(httpHeaders, bookRatingsRequest);

        List<Book> books = response.booksInfo()
                .stream()
                .map(bookInfo -> {
                            BookRating bookRating = bookRatingsResponse.bookRatings()
                                    .stream()
                                    .filter(rating -> bookInfo.id() % 3 == rating.bookId())
                                    .findFirst()
                                    .orElse(BookRating.builder().build());

                            return Book.builder()
                                    .id(bookInfo.id())
                                    .name(bookInfo.name())
                                    .author(bookInfo.author())
                                    .description(bookInfo.description())
                                    .rating(bookRating.rating())
                                    .reviews(bookRating.reviews())
                                    .build();
                        }
                )
                .toList();

        log.info("books size: {}", books.size());

        return GetAllBooksResponse.builder()
                .books(books)
                .build();
    }
}
