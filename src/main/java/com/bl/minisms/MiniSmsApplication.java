package com.bl.minisms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.bl.minisms.mapper")
public class MiniSmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiniSmsApplication.class, args);
    }

}
