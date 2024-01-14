package com.digitalcode.client.fr;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;

import com.digitalcode.client.fr.entity.jpa.Client;
import com.digitalcode.client.fr.repository.ClientRepository;
import com.digitalcode.exception.GlobalExceptionHandler;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.digitalcode")
@DependsOn("globalExceptionHandler")
public class ClientApplication implements CommandLineRunner {

	@Autowired
	ClientRepository clientRepository;

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
		// printBean();
	}

	public static void printBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(GlobalExceptionHandler.class);

		String[] beanNames = context.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			System.out.println("Bean Name: " + beanName);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext context = new AnnotationConfigApplicationContext(GlobalExceptionHandler.class);
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		System.out.println("Liste des noms de tous les beans dans l'application :");
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}

		clientRepository.save(new Client(1L, "salem", "salem", "salem@salem.com"));
		clientRepository.save(new Client(2L, "rami", "rami", "rami@rami.com"));

	}

}
