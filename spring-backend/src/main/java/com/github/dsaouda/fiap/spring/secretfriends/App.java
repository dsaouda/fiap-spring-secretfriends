package com.github.dsaouda.fiap.spring.secretfriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
@EnableAutoConfiguration
public class App {
	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
