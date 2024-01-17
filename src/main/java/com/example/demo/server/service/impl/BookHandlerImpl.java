package com.example.demo.server.service.impl;

import com.example.demo.server.domain.Book;
import com.example.demo.server.repository.BookRepository;
import com.example.demo.server.response.GetAllBookResponse;
import com.example.demo.server.service.BookHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookHandlerImpl implements BookHandlerService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<GetAllBookResponse> getAllBooks(int page, int size) {
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.by(Sort.Direction.DESC, Book.CREATED_AT)
        );

        Page<Book> pageResult = bookRepository.findAll(pageRequest);

        return pageResult.getContent().stream()
                .map(this::castToResponse).collect(Collectors.toList());
    }

    @Override
    public List<GetAllBookResponse> getBookByName(String bookName) {
        return bookRepository.searchRelatedBookByName(bookName).stream().map(this::castToResponse).toList();
    }

    private GetAllBookResponse castToResponse(Book book) {
        return new GetAllBookResponse(
                book.getBookId(),
                book.getName(),
                book.getDescription(),
                book.getPrice(),
                book.getCreatedAt(),
                book.getUpdatedAt());
    }

    @Override
    public void addBook(Book addedBook) {
        bookRepository.save(addedBook);
    }

    @Override
    public void updateBook(Book updatedBook) {
        bookRepository.save(updatedBook);
    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public Optional<Book> getBookById(String bookId) {
        return bookRepository.findById(bookId);
    }
}
