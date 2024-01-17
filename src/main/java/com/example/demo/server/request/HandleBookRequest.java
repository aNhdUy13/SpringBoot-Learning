package com.example.demo.server.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class HandleBookRequest {

    private String bookId;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private String description;

    @NotNull
    private Double price;

    private Long createdAt;

    private Long updatedAt;
}
