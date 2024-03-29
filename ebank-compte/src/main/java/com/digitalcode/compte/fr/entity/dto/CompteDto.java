package com.digitalcode.compte.fr.entity.dto;

import com.digitalcode.enums.TypeCompte;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompteDto {

	private Long id;

	private TypeCompte typeCompte;

	private Long clientId;

	private Client client;
}
