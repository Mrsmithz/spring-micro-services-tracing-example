package com.example.bookinfoservice.controller.implment;

import com.example.bookinfoservice.controller.BookInfoController;
import com.example.bookinfoservice.model.request.GetBooksInfoRequest;
import com.example.bookinfoservice.model.response.GetBooksInfoResponse;
import com.example.bookinfoservice.service.BookInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookInfoControllerImpl implements BookInfoController {

    private final BookInfoService bookInfoService;

    @Override
    public GetBooksInfoResponse getBooksInfo(GetBooksInfoRequest request) {
        return bookInfoService.getBooksInfo(request);
    }
}
