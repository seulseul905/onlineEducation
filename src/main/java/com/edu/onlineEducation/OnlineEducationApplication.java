package com.edu.onlineEducation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.edu.*")
public class OnlineEducationApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineEducationApplication.class, args);
        System.out.println("Hello JAVA");
    }
}
