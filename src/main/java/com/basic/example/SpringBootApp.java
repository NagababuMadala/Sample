package com.basic.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.basic.example.util.EmployeeConstants.BASE_PACKAGE;

@SpringBootApplication
@ComponentScan(BASE_PACKAGE)
@EnableSwagger2
@EnableCaching
@EnableScheduling
public class SpringBootApp extends SpringBootServletInitializer {
    private static Logger logger = LoggerFactory.getLogger(SpringBootApp.class);

        public static void main(String[] args) {
            logger.debug(" Spring Boot Application Started");
            SpringApplication.run(SpringBootApp.class, args);
        }
}
