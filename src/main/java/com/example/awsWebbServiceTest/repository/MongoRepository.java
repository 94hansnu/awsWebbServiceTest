package com.example.awsWebbServiceTest.repository;

import com.example.awsWebbServiceTest.models.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepository extends org.springframework.data.mongodb.repository.MongoRepository<Book, String> {
}
