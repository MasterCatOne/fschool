package com.example.fschool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.fschool.mapper")
@SpringBootApplication
public class FschoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(FschoolApplication.class, args);
    }

}
