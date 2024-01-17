package com.example.demo.server.api;

import com.example.demo.server.domain.Book;
import com.example.demo.server.response.ApplicationResponseBody;
import com.example.demo.server.response.ResponseCode;
import com.example.demo.server.service.BookHandlerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class DeleteBookApi {

    private final BookHandlerService bookHandlerService;

    public ApplicationResponseBody doExecute(String bookId) {
        Optional<Book> optionalBook = bookHandlerService.getBookById(bookId);
        if (optionalBook.isPresent()) {
            bookHandlerService.deleteBook(bookId);
            return new ApplicationResponseBody(ResponseCode.SUCCESS);
        }
        return new ApplicationResponseBody(ResponseCode.WRONG_DATA_FORMAT);
    }
}
