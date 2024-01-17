package com.example.demo.server.controller;

import com.example.demo.server.api.*;
import com.example.demo.server.domain.Book;
import com.example.demo.server.request.HandleBookRequest;
import com.example.demo.server.response.ApplicationResponseBody;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
public class BookController {

    private final GetAllBooksApi getAllApi;
    private final AddBookApi addBookApi;
    private final UpdateBookApi updateBookApi;
    private final DeleteBookApi deleteBookApi;
    private final GetBookByNameApi getBookByNameApi;

    @GetMapping("/getAllBooks")
    public ApplicationResponseBody getAllBooks(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "24") int size
    ) {
        return getAllApi.doExecute(page, size);
    }


    @PostMapping(value = "/addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationResponseBody addBook(@RequestBody HandleBookRequest handleBookRequest) {
        return addBookApi.doExecute(handleBookRequest);
    }

    @PutMapping(value = "/updateBook/{bookId}")
    public ApplicationResponseBody updateBook(
            @PathVariable("bookId") String bookId,
            @RequestBody HandleBookRequest handleBookRequest
    ) {
        return updateBookApi.doExecute(bookId, handleBookRequest);
    }

    @DeleteMapping(value = "/deleteBook/{bookId}")
    public ApplicationResponseBody deleteBook(@PathVariable("bookId") String bookId) {
        return deleteBookApi.doExecute(bookId);
    }

    @GetMapping(value = "/getBookByName")
    public ApplicationResponseBody getBooksByName(@RequestParam String bookName) {
        return getBookByNameApi.doExecute(bookName);
    }
}
