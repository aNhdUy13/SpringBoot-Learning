package com.example.demo.server.service.impl;

import com.example.demo.server.domain.Book;
import com.example.demo.server.repository.BookRepository;
import com.example.demo.server.response.GetAllBookResponse;
import com.example.demo.server.response.ResponseCode;
import com.example.demo.server.service.BookHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
                .map(book -> new GetAllBookResponse(
                        book.getBookId(),
                        book.getName(),
                        book.getDescription(),
                        book.getPrice(),
                        book.getCreatedAt(),
                        book.getUpdatedAt()
                )).collect(Collectors.toList());
    }

    @Override
    public int addBook(Book addedBook) {
        bookRepository.save(addedBook);
        return ResponseCode.SUCCESS;
    }

    @Override
    public int updateBook(Book updatedBook) {
        bookRepository.save(updatedBook);
        return ResponseCode.SUCCESS;
    }

    @Override
    public int deleteBook(String bookId) {
        Optional<Book> deletedBook = bookRepository.findById(bookId);
        if (deletedBook.isEmpty()) {
            return ResponseCode.WRONG_DATA_FORMAT;
        }
        bookRepository.deleteById(bookId);
        return ResponseCode.SUCCESS;
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        return bookRepository.searchRelatedBookByName(bookName);
    }

    @Override
    public Book getBookById(String bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Book not found with id: " + bookId));
    }
}
