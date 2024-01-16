package com.digitalcode.compte.fr.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.digitalcode.compte.fr.entity.dto.Client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "CLIENT-SERVICE")
public interface EbankClientRest {

	@CircuitBreaker(name = "CLIENT-SERVICE", fallbackMethod = "getDefaultClient")
	@GetMapping("clients/{id}")
	public Client getClientById(@PathVariable Long id);

	/**
	 * getDefaultClient : if client service not available then this method will be
	 * called
	 * 
	 * @param id    : the id of client
	 * @param cause : contain the original exception (required by the CircuitBreaker
	 *              annotation to define a valid fallback method signature)
	 * @return : Client
	 */
	default Client getDefaultClient(Long id, Throwable cause) {
		return new Client(0L, "toto", "toto", "toto@toto.toto");
	}
}
