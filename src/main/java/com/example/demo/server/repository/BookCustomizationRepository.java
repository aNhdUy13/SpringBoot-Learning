package com.example.demo.server.repository;

import com.example.demo.server.domain.Book;

import java.util.List;

public interface BookCustomizationRepository {

    List<Book> searchRelatedBookByName(String name);
}
