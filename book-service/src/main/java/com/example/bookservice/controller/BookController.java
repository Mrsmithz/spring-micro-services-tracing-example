package com.example.bookservice.controller;

import com.example.bookservice.model.response.GetAllBooksResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/books")
public interface BookController {

    @GetMapping("/all")
    GetAllBooksResponse getAllBooks();
}
