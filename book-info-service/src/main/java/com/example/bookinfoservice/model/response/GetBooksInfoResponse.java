package com.example.bookinfoservice.model.response;

import com.example.bookinfoservice.model.BookInfo;
import lombok.Builder;

import java.util.List;

@Builder
public record GetBooksInfoResponse(List<BookInfo> booksInfo) {
}
