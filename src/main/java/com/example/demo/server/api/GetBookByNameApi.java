package com.example.demo.server.api;

import com.example.demo.server.response.ApplicationResponseBody;
import com.example.demo.server.response.GetAllBookResponse;
import com.example.demo.server.service.BookHandlerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class GetBookByNameApi {

    private final BookHandlerService bookHandlerService;

    public ApplicationResponseBody doExecute(String bookName) {
        List<GetAllBookResponse> bookResponseList = bookHandlerService.getBookByName(bookName);
        return new ApplicationResponseBody(bookResponseList);
    }
}
