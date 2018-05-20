package com.pofy.chqty;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pofy.chqty.mapper")
public class SevenUpWebServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SevenUpWebServiceApplication.class, args);
    }
}
