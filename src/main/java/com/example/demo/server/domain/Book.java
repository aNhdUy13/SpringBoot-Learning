package com.example.demo.server.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Setter
@Getter
@Document
@Builder
public class Book {

    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String PRICE = "price";
    public static final String CREATED_AT = "created_at";
    public static final String UPDATED_AT = "updated_at";

    @Id
    private String bookId;
    @Field(NAME)
    private String name;
    @Field(DESCRIPTION)
    private String description;
    @Field(PRICE)
    private Double price;
    @Field(CREATED_AT)
    private Long createdAt;
    @Field(UPDATED_AT)
    private Long updatedAt;

//    public Book(String name, String description, Double price, Long createdAt, Long updatedAt) {
//        this.name = name;
//        this.description = description;
//        this.price = price;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//    }
}
