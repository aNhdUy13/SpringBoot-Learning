package com.example.demo.server.api;

import com.example.demo.server.response.ApplicationResponseBody;
import com.example.demo.server.response.GetAllBookResponse;
import com.example.demo.server.service.BookHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllBooksApi {

    @Autowired
    private BookHandlerService bookHandlerService;

    public ApplicationResponseBody doExecute(int page, int size, String name) {
        List<GetAllBookResponse> processedBooksResponse = (!name.isEmpty() && !name.isBlank())
                ? bookHandlerService.getBookByName(name) : bookHandlerService.getAllBooks(page, size);
        return new ApplicationResponseBody(processedBooksResponse);
    }
}
