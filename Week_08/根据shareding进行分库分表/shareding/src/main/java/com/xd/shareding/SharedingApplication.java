package com.xd.shareding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xd.shareding.mapper")
@SpringBootApplication
public class SharedingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharedingApplication.class, args);
    }

}
