package com.byrc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.byrc.byyc.mapper")
public class ByrcjtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ByrcjtApplication.class, args);
    }

}
