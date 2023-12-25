package com.digitalcode.ebank.fr;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class CheckGateway {

	@GetMapping
	public String hello() {
		return "gateway work's fine";
	}
}
