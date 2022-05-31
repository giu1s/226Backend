package com.sports.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.sports.plan")
@EnableMongoRepositories({ "com.sports.plan.repositories" })
public class PlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanApplication.class, args);
	}

}
