package com.example.demo.server.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class GetAllBookResponse {
    private String bookId;
    private String name;
    private String description;
    private Double price;
    private Long createdAt;
    private Long updatedAt;
}
