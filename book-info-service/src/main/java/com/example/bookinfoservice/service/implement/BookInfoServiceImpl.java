package com.example.bookinfoservice.service.implement;


import com.example.bookinfoservice.model.BookInfo;
import com.example.bookinfoservice.model.request.GetBooksInfoRequest;
import com.example.bookinfoservice.model.response.GetBooksInfoResponse;
import com.example.bookinfoservice.service.BookInfoService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Service
public class BookInfoServiceImpl implements BookInfoService {

    private final Random random = new Random();

    @Override
    @SneakyThrows
    public GetBooksInfoResponse getBooksInfo(GetBooksInfoRequest request) {
        final Map<Integer, BookInfo> books = random.ints(20, 1, 100)
                .boxed()
                .distinct()
                .map(i -> BookInfo.builder()
                        .id(i)
                        .name("Book Name " + i)
                        .author("Mrsmithz")
                        .description("book description of " + i)
                        .build()
                )
                .toList()
                .stream()
                .collect(Collectors.toMap(BookInfo::id, Function.identity()));

        log.info("Book Info: {}", books);

        List<BookInfo> bookInfos = Optional.ofNullable(request.bookIds())
                .orElse(Collections.emptyList())
                .stream()
                .map(i -> books.getOrDefault(i, null))
                .filter(Objects::nonNull)
                .toList();

        Thread.sleep(random.nextInt(10, 5000));

        return GetBooksInfoResponse.builder()
                .booksInfo(bookInfos)
                .build();
    }
}
