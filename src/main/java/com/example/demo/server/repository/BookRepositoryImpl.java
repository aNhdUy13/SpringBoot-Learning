package com.example.demo.server.repository;

import com.example.demo.server.domain.Book;
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
    public List<Book> searchRelatedBookByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where(Book.NAME).regex(Pattern.compile(name)));
        return mongoTemplate.find(query, Book.class);
    }
}
