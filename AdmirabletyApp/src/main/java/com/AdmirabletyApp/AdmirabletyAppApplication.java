package com.AdmirabletyApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.AdmireabletyApp*"})
@EntityScan({"com.AdmireabletyApp*"})
@EnableJpaRepositories({"com.AdmireabletyApp*"})
public class AdmirabletyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdmirabletyAppApplication.class, args);
	}

}
