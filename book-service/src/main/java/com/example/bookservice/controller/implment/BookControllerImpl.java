package com.example.bookservice.controller.implment;

import com.example.bookservice.controller.BookController;
import com.example.bookservice.model.response.GetAllBooksResponse;
import com.example.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @Override
    public GetAllBooksResponse getAllBooks() {
        return bookService.getAllBooks();
    }
}
