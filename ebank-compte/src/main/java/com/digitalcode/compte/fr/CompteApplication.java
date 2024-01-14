package com.digitalcode.compte.fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DependsOn;

import com.digitalcode.compte.fr.entity.jpa.Compte;
import com.digitalcode.compte.fr.repository.CompteRepository;
import com.digitalcode.enums.TypeCompte;
import com.google.common.collect.ComparisonChain;

@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = "com.digitalcode")
@DependsOn("globalExceptionHandler")
@EnableFeignClients
public class CompteApplication implements CommandLineRunner {

	@Autowired
	private CompteRepository compteRepository;

	public static void main(String[] args) {
		SpringApplication.run(CompteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		compteRepository.save(new Compte(1L, TypeCompte.CURRENT_ACCOUNT, 2L));
		compteRepository.save(new Compte(2L, TypeCompte.CURRENT_ACCOUNT, 1L));
		compteRepository.save(new Compte(3L, TypeCompte.CURRENT_ACCOUNT, 1L));
		compteRepository.save(new Compte(4L, TypeCompte.CURRENT_ACCOUNT, 2L));

	}

}
