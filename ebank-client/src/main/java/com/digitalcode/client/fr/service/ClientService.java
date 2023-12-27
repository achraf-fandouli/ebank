package com.digitalcode.client.fr.service;

import java.util.List;
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

	public Client updateClient(Client client) throws Exception {
		Optional<Client> result = clientRepository.findById(client.getId());
		if (result.isPresent()) {
			return clientRepository.save(client);
		} else {
			throw new Exception("Client Not Exist with Id: " + client.getId());
		}
	}

	public Client getClientById(Long id) throws Exception {
		return clientRepository.findById(id).orElseThrow(() -> new Exception("Client Not Fond with Id: " + id));
	}

	public void deleteClienttById(Long id) throws Exception {
		Optional<Client> client = clientRepository.findById(id);
		if (client.isPresent()) {
			clientRepository.deleteById(id);
		} else {
			throw new Exception("Client Not Exist with Id: " + id);
		}
	}

	public List<Client> findAllClient() {
		return clientRepository.findAll();
	}
}
