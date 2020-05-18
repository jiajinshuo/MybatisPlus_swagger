package com.jiajinshuo.mplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jiajinshuo.mplus.mapper")
@SpringBootApplication
public class MplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MplusApplication.class, args);
    }

}
