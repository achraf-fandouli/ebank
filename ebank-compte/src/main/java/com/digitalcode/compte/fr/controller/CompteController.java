package com.digitalcode.compte.fr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digitalcode.compte.fr.entity.dto.Client;
import com.digitalcode.compte.fr.entity.dto.CompteDto;
import com.digitalcode.compte.fr.entity.jpa.Compte;
import com.digitalcode.compte.fr.mapper.MapperUtil;
import com.digitalcode.compte.fr.openfeign.EbankClientRest;
import com.digitalcode.compte.fr.service.CompteService;

@RequestMapping("/comptes")
@RestController
public class CompteController {

	private CompteService compteService;

	private EbankClientRest ebankClientRest;

	public CompteController(CompteService compteService, EbankClientRest ebankClientRest) {
		this.compteService = compteService;
		this.ebankClientRest = ebankClientRest;
	}

	@GetMapping("/{id}")
	public ResponseEntity<CompteDto> getCompteById(@PathVariable Long id) throws Exception {
		CompteDto compteDto = MapperUtil.convertCompteToDto(compteService.getCompteById(id));
		Client client = ebankClientRest.getClientById(compteDto.getClientId());
		compteDto.setClient(client);
		return ResponseEntity.ok().body(compteDto);
	}

	@GetMapping
	public ResponseEntity<List<CompteDto>> getAllCompte() throws Exception {
		List<CompteDto> comptesDto = Optional
				.ofNullable(MapperUtil.CompteListToconvertDtoList(compteService.getAllCompte())).orElse(List.of());
		comptesDto.forEach(compte -> {
			compte.setClient(ebankClientRest.getClientById(compte.getClientId()));

		});
		return ResponseEntity.ok().body(comptesDto);
	}
}
