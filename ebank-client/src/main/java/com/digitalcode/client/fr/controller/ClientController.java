package com.digitalcode.client.fr.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public ResponseEntity deleteClienttById(@PathVariable Long id) throws Exception {
		try {
			clientService.deleteClienttById(id);
			return new ResponseEntity<>("Successfully deleted the client with Id: " + id, HttpStatus.CREATED);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>("No client is found !!", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping()
	public ResponseEntity<List<ClientDto>> findAllClient() {
		List<Client> clients = clientService.findAllClient();
		List<ClientDto> response = new ArrayList();
		for (Client client : clients) {
			response.add(MapperUtil.convertClientToDto(client));
		}
		return ResponseEntity.ok().body(response);
	}

}
