package com.example.demo.repository;

import com.example.demo.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.regex.Pattern;

public class BookRepositoryImpl implements BookCustomizationRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Book> searchBook(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where(Book.NAME).regex(Pattern.compile(name)));
        return mongoTemplate.find(query, Book.class);
    }
}
