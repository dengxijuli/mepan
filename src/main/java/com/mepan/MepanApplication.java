package com.mepan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@SpringBootApplication(scanBasePackages = {"com.mepan"})
@MapperScan(basePackages = {"com.mepan.mapper"})
@EnableTransactionManagement
@EnableScheduling
public class MepanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MepanApplication.class, args);
    }

}
