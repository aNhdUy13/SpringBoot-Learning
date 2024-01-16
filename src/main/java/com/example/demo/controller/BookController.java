package com.example.demo.controller;

import com.example.demo.models.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping(value = "/addBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Book addBook(@RequestBody CreateBookRequest request){

        Book book = new Book(request.getTitle());
        return bookRepository.save(book);
    }

    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
