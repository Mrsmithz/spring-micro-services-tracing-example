package com.example.bookratingsservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "book_rating")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookRating {

    @MongoId
    private String id;

    private Integer bookId;

    private Double rating;

    private String reviews;
}
