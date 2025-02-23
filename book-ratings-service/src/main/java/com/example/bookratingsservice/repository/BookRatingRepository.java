package com.example.bookratingsservice.repository;

import com.example.bookratingsservice.entity.BookRating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRatingRepository extends MongoRepository<BookRating, String> {

    List<BookRating> findAllByBookIdIn(List<Integer> bookIds);
}
