package com.example.demo.server.controller;

import com.example.demo.server.api.*;
import com.example.demo.server.request.HandleBookRequest;
import com.example.demo.server.response.ApplicationResponseBody;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private GetAllBooksApi getAllApi;
    private AddBookApi addBookApi;
    private UpdateBookApi updateBookApi;
    private DeleteBookApi deleteBookApi;
    private GetBookByNameApi getBookByNameApi;

    @GetMapping("/getAllBooks")
    public ApplicationResponseBody getAllBooks(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "24") int size,
            @RequestParam(value = "name", required = false, defaultValue = "") String name
    ) {
        return getAllApi.doExecute(page, size, name);
    }


    @PostMapping(value = "/addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ApplicationResponseBody addBook(@Valid @RequestBody HandleBookRequest handleBookRequest) {
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
}
