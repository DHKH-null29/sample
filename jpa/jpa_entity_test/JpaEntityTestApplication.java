package com.example.jpa_entity_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaEntityTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaEntityTestApplication.class, args);
	}

}
