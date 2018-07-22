package com.solopov.hillel.uquiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class UquizApplication {

	public static void main(String[] args) {
		SpringApplication.run(UquizApplication.class, args);
	}
}
