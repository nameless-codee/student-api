package com.niru.student_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApiApplication {

    // Entry point of the Spring Boot application
	public static void main(String[] args) {

        // SpringApplication.run() is used to run the Spring Boot application
        // @SpringBootApplication is a convenience annotation that adds all the following:
        // @Configuration: Tags the class as a source of bean definitions for the application context.
        // @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
        // @ComponentScan: Tells Spring to look for other components, configurations, and services in the com.niru.student_api package, allowing it to find the controllers.
        SpringApplication.run(StudentApiApplication.class, args);
	}

}
