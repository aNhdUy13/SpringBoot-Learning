package com.example.demo.server.api;

import com.example.demo.server.domain.Book;
import com.example.demo.server.request.HandleBookRequest;
import com.example.demo.server.response.ApplicationResponseBody;
import com.example.demo.server.service.BookHandlerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AddBookApi {
    private final BookHandlerService bookHandlerService;

    public ApplicationResponseBody doExecute(HandleBookRequest handleBookRequest) {
        Book book = new Book(
                handleBookRequest.getName(),
                handleBookRequest.getDescription(),
                handleBookRequest.getPrice(),
                handleBookRequest.getCreatedAt(),
                handleBookRequest.getUpdatedAt()
        );
        return new ApplicationResponseBody(bookHandlerService.addBook(book));
    }
}
