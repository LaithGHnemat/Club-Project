package com.example.laith.test.springdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DatabaseInfoController {

    @GetMapping("/db-info")
    public String getDatabaseInfo() {
        // this for check the info coming from docker-compose
        // when you use docker-compose it will override what inside the properties
        String dbUrl = Optional.ofNullable(System.getenv("SPRING_DATASOURCE_URL"))
                .filter(url -> !url.isEmpty())
                .orElse("Database URL is not set");
        String dbUsername = Optional.ofNullable(System.getenv("SPRING_DATASOURCE_USERNAME"))
                .filter(username -> !username.isEmpty())
                .orElse("Username is not set");
        String dbPassword = Optional.ofNullable(System.getenv("SPRING_DATASOURCE_PASSWORD"))
                .filter(password -> !password.isEmpty())
                .orElse("Password is not set");
        String dbName = dbUrl.contains("/") ? dbUrl.split("/")[3] : "Unknown";
        return String.format("Database URL: %s\nDatabase Name: %s\nUsername: %s\nPassword: %s",
                dbUrl, dbName, dbUsername, dbPassword);

    }

}
