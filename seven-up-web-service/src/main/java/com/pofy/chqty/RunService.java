package com.pofy.chqty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@tk.mybatis.spring.annotation.MapperScan("com.pofy.chqty.mapper")
public class RunService {

    public static void main(String[] args) {
        SpringApplication.run(RunService.class, args);
    }
}
