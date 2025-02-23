package com.example.bookinfoservice.controller;

import com.example.bookinfoservice.model.request.GetBooksInfoRequest;
import com.example.bookinfoservice.model.response.GetBooksInfoResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/books-info")
public interface BookInfoController {

    @PostMapping
    GetBooksInfoResponse getBooksInfo(@RequestBody GetBooksInfoRequest request);
}
