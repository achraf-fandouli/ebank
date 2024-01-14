package com.digitalcode.compte.fr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalcode.compte.fr.entity.jpa.Compte;
import com.digitalcode.compte.fr.repository.CompteRepository;

@Service
public class CompteService {

	private CompteRepository compteRepository;

	public CompteService(CompteRepository compte) {
		this.compteRepository = compte;
	}

	public Compte getCompteById(Long id) throws Exception {
		return compteRepository.findById(id).orElseThrow(() -> new Exception("Account Not Fond with Id: " + id));
	}

	public Compte saveCompte(Compte compte) {
		return compteRepository.save(compte);
	}

	public List<Compte> getAllCompte() {
		return compteRepository.findAll();
	}

}
