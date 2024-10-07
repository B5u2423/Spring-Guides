package com.demo.accessmysql;

import org.springframework.boot.SpringApplication;

public class TestAccessmysqlApplication {

    public static void main(String[] args) {
        SpringApplication.from(AccessmysqlApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
