package com.example.bookservice.feign;

import com.example.bookservice.feign.request.GetBookRatingsRequest;
import com.example.bookservice.feign.response.GetBookRatingsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "book-ratings-service", url = "${feign.book-ratings-service.url}")
public interface BookRatingServiceFeign {

    @PostMapping("/book-ratings")
    GetBookRatingsResponse getBookRatings(
            @RequestHeader HttpHeaders headers,
            @RequestBody GetBookRatingsRequest request
    );
}
