package com.example.finalpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.finalpro.mapper")
public class FinalproApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalproApplication.class, args);
    }

}
