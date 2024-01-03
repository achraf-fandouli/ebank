package com.digitalcode.compte.fr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.digitalcode")
public class CompteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteApplication.class, args);
	}

}
