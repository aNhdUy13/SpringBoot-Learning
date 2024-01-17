package com.example.demo.server.api;

import com.example.demo.server.domain.Book;
import com.example.demo.server.request.HandleBookRequest;
import com.example.demo.server.response.ApplicationResponseBody;
import com.example.demo.server.service.BookHandlerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UpdateBookApi {

    private final BookHandlerService bookHandlerService;

    public ApplicationResponseBody doExecute(String bookId, HandleBookRequest handleBookRequest) {
        Book updatedBook = bookHandlerService.getBookById(bookId);
        updatedBook.setName(handleBookRequest.getName());
        updatedBook.setDescription(handleBookRequest.getDescription());
        updatedBook.setPrice(handleBookRequest.getPrice());
        updatedBook.setCreatedAt(handleBookRequest.getCreatedAt());
        updatedBook.setUpdatedAt(handleBookRequest.getUpdatedAt());
        return new ApplicationResponseBody(bookHandlerService.updateBook(updatedBook));
    }
}
