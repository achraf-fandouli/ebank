package com.digitalcode.client.fr.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.digitalcode.client.fr.entity.jpa.Client;
import com.digitalcode.client.fr.repository.ClientRepository;

@Service
public class ClientService {

	private ClientRepository clientRepository;

	public ClientService(ClientRepository client) {
		this.clientRepository = client;
	}

	public Client saveClient(Client client) {
		return clientRepository.save(client);

	}

	public Client getClienttById(Long id) throws Exception {
		Optional<Client> client = clientRepository.findById(id);
		if (client.isPresent()) {
			return client.get();
		} else {
			throw new Exception("Client Not Fond");
		}
	}

}
