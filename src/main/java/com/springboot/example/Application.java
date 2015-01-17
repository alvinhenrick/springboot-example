package com.springboot.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.springboot.example")
public class Application
{
    private static Log LOGGER = LogFactory.getLog(Application.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("Starting Spring Boot Application.");
        SpringApplication.run(Application.class, args);
    }
}