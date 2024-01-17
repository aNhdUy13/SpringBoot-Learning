package com.example.demo.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DBConfig {

    public @Bean MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }
}
