package com.example.bookinfoservice.model;

import lombok.Builder;

@Builder
public record BookInfo(Integer id, String name, String author, String description) {

}
