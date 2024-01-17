package com.example.demo.controller;

import com.example.demo.exception.ApplicationException;
import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.request.HandleBookRequest;
import com.example.demo.response.GetAllBookResponse;
import com.example.demo.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.demo.response.ResponseBody.SUCCESS_RESPONSE;
import static com.example.demo.response.ResponseBody.WRONG_DATA_FORMAT_RESPONSE;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/getAllBooks")
    public ResponseBody getAllBooks() {
        return new ResponseBody(bookRepository.findAll());
    }

    @PostMapping(value = "/addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBody addBook(@RequestBody HandleBookRequest handleBookRequest) {
        Book book = new Book(
                handleBookRequest.getName(),
                handleBookRequest.getDescription(),
                handleBookRequest.getPrice(),
                handleBookRequest.getCreatedAt(),
                handleBookRequest.getUpdatedAt()
        );

        try {
            Book savedBook = bookRepository.save(book);

            if (savedBook.getBookId() != null) {
                return new ResponseBody(book);
            }
            return new ResponseBody(WRONG_DATA_FORMAT_RESPONSE);
        } catch (Exception e) {
            return new ResponseBody(WRONG_DATA_FORMAT_RESPONSE);
        }
    }

    @PutMapping(value = "/updateBook/{bookId}")
    public ResponseBody updateBook(
            @PathVariable("bookId") String bookId,
            @RequestBody HandleBookRequest handleBookRequest
    ) {
        try {
            Book updatedBook = bookRepository.findById(bookId)
                    .orElseThrow(() -> new ApplicationException("Book not found with id: " + bookId));
            updatedBook.setName(handleBookRequest.getName());
            updatedBook.setDescription(handleBookRequest.getDescription());
            updatedBook.setPrice(handleBookRequest.getPrice());
            updatedBook.setCreatedAt(handleBookRequest.getCreatedAt());
            updatedBook.setUpdatedAt(handleBookRequest.getUpdatedAt());
            bookRepository.save(updatedBook);

            return new ResponseBody(SUCCESS_RESPONSE);
        } catch (Exception e) {
            return new ResponseBody(WRONG_DATA_FORMAT_RESPONSE);
        }
    }

    @DeleteMapping(value = "/deleteBook/{bookId}")
    public ResponseBody deleteBook(@PathVariable("bookId") String bookId) {
        Book deletedBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new NoSuchElementException("Book not found with id: " + bookId));
        bookRepository.delete(deletedBook);

        return new ResponseBody(SUCCESS_RESPONSE);
    }

    @GetMapping(value = "/getBookByName")
    public ResponseBody getBooksByName(@RequestParam String bookName) {
        List<Book> originalBookList = bookRepository.searchBook(bookName);
        List<GetAllBookResponse> bookResponses = new ArrayList<>();
        return new ResponseBody(originalBookList);
    }
}
