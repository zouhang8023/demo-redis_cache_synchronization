package com.bgs.demoredis_cache_synchronization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan
public class DemoRedisCacheSynchronizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoRedisCacheSynchronizationApplication.class, args);
    }

}
