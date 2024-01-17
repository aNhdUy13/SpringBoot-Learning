package com.example.demo.server.service;


import com.example.demo.server.domain.Book;
import com.example.demo.server.response.GetAllBookResponse;

import java.util.List;
import java.util.Optional;

public interface BookHandlerService {
    List<GetAllBookResponse> getAllBooks(int page, int size);

    List<GetAllBookResponse> getBookByName(String bookName);

    void addBook(Book addedBook);

    void updateBook(Book updatedBook);

    Optional<Book> getBookById(String id);

    void deleteBook(String bookId);
}
