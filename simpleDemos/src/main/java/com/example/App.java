package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * created by dfk
 * 2022/4/23
 */
@SpringBootApplication
@EnableSwagger2
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
