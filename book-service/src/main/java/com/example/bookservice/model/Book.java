package com.example.bookservice.model;

import lombok.Builder;

@Builder
public record Book(Integer id, String name, String author, String description, Double rating, String reviews) {

}
