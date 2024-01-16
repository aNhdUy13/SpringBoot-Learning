package com.example.demo.repository;

import com.example.demo.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findBooksByName(String name);
}
