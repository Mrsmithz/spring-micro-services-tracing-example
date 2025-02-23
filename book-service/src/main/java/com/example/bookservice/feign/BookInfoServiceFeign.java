package com.example.bookservice.feign;

import com.example.bookservice.feign.request.GetBooksInfoRequest;
import com.example.bookservice.feign.response.GetBooksInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "book-info-service", url = "${feign.book-info-service.url}")
public interface BookInfoServiceFeign {

    @PostMapping("/books-info")
    GetBooksInfoResponse getBooksInfo(
            @RequestHeader HttpHeaders headers,
            @RequestBody GetBooksInfoRequest request
    );
}
