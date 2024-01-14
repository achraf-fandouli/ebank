package com.digitalcode.client.fr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcode.client.fr.entity.dto.ClientDto;
import com.digitalcode.client.fr.entity.jpa.Client;
import com.digitalcode.client.fr.mapper.MapperUtil;
import com.digitalcode.client.fr.service.ClientService;

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
		ClientDto response = MapperUtil.convertClientToDto(clientService.getClientById(id));
		return ResponseEntity.ok().body(response);
	}

	@PutMapping
	public ResponseEntity<ClientDto> updateClient(@RequestBody ClientDto clientDto) throws Exception {
		Client client = MapperUtil.convertDtoTOClient(clientDto);
		ClientDto response = MapperUtil.convertClientToDto(clientService.updateClient(client));
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteClienttById(@PathVariable Long id) throws Exception {
		clientService.deleteClienttById(id);
		return new ResponseEntity<>("Successfully deleted the client with Id: " + id, HttpStatus.CREATED);
	}

	@GetMapping()
	public ResponseEntity<List<ClientDto>> findAllClient() {
		List<Client> clients = Optional.ofNullable(clientService.findAllClient()).orElse(List.of());
		List<ClientDto> response = clients.stream().map(client -> MapperUtil.convertClientToDto(client)).toList();
		return ResponseEntity.ok().body(response);
	}

}
