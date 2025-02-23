package com.example.bookservice.feign.response;

import lombok.Builder;

@Builder
public record BookInfo(Integer id, String name, String author, String description) {

}
