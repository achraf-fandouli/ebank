package com.digitalcode.compte.fr.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.digitalcode.compte.fr.entity.dto.Client;

@FeignClient(name = "CLIENT-SERVICE")
public interface EbankClientRest {

	@GetMapping("clients/{id}")
	public Client getClientById(@PathVariable Long id);
}
