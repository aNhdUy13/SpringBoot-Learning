package com.example.demo.server.service;


import com.example.demo.server.domain.Book;

import java.util.List;

public interface BookHandlerService {
    List<Book> getAllBooks(int page, int size);

    int addBook(Book addedBook);
    int updateBook(Book updatedBook);

    Book getBookById(String id);

    int deleteBook(String bookId);

    List<Book> getBookByName(String bookName);
}
