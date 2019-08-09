package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * 
 * Under the hood, @SpringBootApplication 
 * is a composition of the @Configuration, 
 * @ComponentScan, and 
 * @EnableAutoConfiguration annotations. 
 * With this default setting, Spring Boot will auto scan for components in the current package (containing the @SpringBoot main class) and its sub packages.
 * @author manoh
 *
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
