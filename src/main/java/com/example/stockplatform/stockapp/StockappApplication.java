package com.example.stockplatform.stockapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main class to start SpringBoot app
 */
@SpringBootApplication
@EnableScheduling
public class StockappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockappApplication.class, args);
	}
}
