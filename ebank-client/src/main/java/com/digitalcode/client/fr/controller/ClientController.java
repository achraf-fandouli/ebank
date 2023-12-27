package com.digitalcode.client.fr.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcode.client.fr.entity.dto.ClientDto;
import com.digitalcode.client.fr.entity.jpa.Client;
import com.digitalcode.client.fr.service.ClientService;
import com.digitalcode.client.fr.util.MapperUtil;

@RestController
@RequestMapping("/clients")
public class ClientController {

	private ClientService clientService;

	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	public ResponseEntity<ClientDto> saveClient(@RequestBody ClientDto clientDto) {
		Client client = MapperUtil.convertDtoTOClient(clientDto);
		ClientDto response = MapperUtil.convertClientToDto(clientService.saveClient(client));
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClientDto> getClient(@PathVariable Long id) throws Exception {
		ClientDto response = MapperUtil.convertClientToDto(clientService.getClienttById(id));
		return ResponseEntity.ok().body(response);
	}
}
