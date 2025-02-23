package com.example.bookservice.model.response;

import com.example.bookservice.model.Book;
import lombok.Builder;

import java.util.List;

@Builder
public record GetAllBooksResponse(List<Book> books) {
}
