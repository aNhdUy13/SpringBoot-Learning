package com.example.demo.server.request;

import lombok.Getter;

@Getter
public class HandleBookRequest {
    private String bookId;
    private String name;
    private String description;
    private Double price;
    private Long createdAt;
    private Long updatedAt;
 }
