package com.example.bookinfoservice.service;

import com.example.bookinfoservice.model.request.GetBooksInfoRequest;
import com.example.bookinfoservice.model.response.GetBooksInfoResponse;

public interface BookInfoService {

    GetBooksInfoResponse getBooksInfo(GetBooksInfoRequest request);
}
