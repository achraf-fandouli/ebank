package com.digitalcode.springadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@EnableAdminServer
@SpringBootApplication
public class EbankSpringadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(EbankSpringadminApplication.class, args);
	}

}
