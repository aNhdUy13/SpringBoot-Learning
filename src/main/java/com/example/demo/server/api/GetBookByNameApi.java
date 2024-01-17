package com.example.demo.server.api;

import com.example.demo.server.response.ApplicationResponseBody;
import com.example.demo.server.service.BookHandlerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class GetBookByNameApi {

    private final BookHandlerService bookHandlerService;

    public ApplicationResponseBody doExecute(String bookName) {
        return new ApplicationResponseBody(bookHandlerService.getBookByName(bookName));
    }
}
