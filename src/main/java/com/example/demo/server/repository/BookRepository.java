package com.example.demo.server.repository;

import com.example.demo.server.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends MongoRepository<Book, String>, BookCustomizationRepository {

    List<Book> findBooksByName(String name);
}