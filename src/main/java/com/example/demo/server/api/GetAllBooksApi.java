package com.example.demo.server.api;

import com.example.demo.server.response.ApplicationResponseBody;
import com.example.demo.server.service.BookHandlerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GetAllBooksApi {

    private final BookHandlerService bookHandlerService;

    public ApplicationResponseBody doExecute(int page, int size) {
        return new ApplicationResponseBody(bookHandlerService.getAllBooks(page, size));
    }
}
