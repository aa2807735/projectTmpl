package com.project.name;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.project.name.repository")
public class ProjectNameApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjectNameApplication.class);
    }
}
