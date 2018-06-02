package com.pofy.chqty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.pofy.chqty"})
@tk.mybatis.spring.annotation.MapperScan("com.pofy.chqty.mapper")
public class RunService {

    public static void main(String[] args) {
        SpringApplication.run(RunService.class, args);
    }
}
