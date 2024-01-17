package com.example.demo.repository;

import com.example.demo.models.Book;

import java.util.List;

public interface BookCustomizationRepository {

    List<Book> searchBook(String name);
}
