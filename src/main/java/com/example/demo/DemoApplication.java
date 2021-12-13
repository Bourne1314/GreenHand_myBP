package com.example.demo;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@MapperScan("com.example.demo.mapper")
@SpringBootApplication
//@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoDataSourceProxy
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("这是我的demo初始化项目！");
        //test
    }
}