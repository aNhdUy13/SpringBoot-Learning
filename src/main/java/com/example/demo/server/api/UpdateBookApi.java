package com.example.demo.server.api;

import com.example.demo.server.request.HandleBookRequest;
import com.example.demo.server.response.ApplicationResponseBody;
import com.example.demo.server.response.ResponseCode;
import com.example.demo.server.service.BookHandlerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UpdateBookApi {

    private final BookHandlerService bookHandlerService;

    public ApplicationResponseBody doExecute(String bookId, HandleBookRequest handleBookRequest) {
        return bookHandlerService.getBookById(bookId)
                .map(bookToUpdate -> {
                    bookToUpdate.setName(handleBookRequest.getName());
                    bookToUpdate.setDescription(handleBookRequest.getDescription());
                    bookToUpdate.setPrice(handleBookRequest.getPrice());
                    bookToUpdate.setCreatedAt(handleBookRequest.getCreatedAt());
                    bookToUpdate.setUpdatedAt(handleBookRequest.getUpdatedAt());
                    bookHandlerService.updateBook(bookToUpdate);
                    return new ApplicationResponseBody(ResponseCode.SUCCESS);
                })
                .orElse(new ApplicationResponseBody(ResponseCode.UNKNOWN_ERROR));
    }
}
