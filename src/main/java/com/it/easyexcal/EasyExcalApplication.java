package com.it.easyexcal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.it.easyExcal.mapper")
public class EasyExcalApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyExcalApplication.class, args);
    }

}
