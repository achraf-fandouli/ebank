package com.digitalcode.compte.fr.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import com.digitalcode.compte.fr.entity.dto.CompteDto;
import com.digitalcode.compte.fr.entity.jpa.Compte;

public class MapperUtil {

	private static ModelMapper modelMapper = new ModelMapper();

	public static CompteDto convertCompteToDto(Compte compte) {
		return modelMapper.map(compte, CompteDto.class);
	}

	public static Compte convertDtoToCompte(CompteDto compteDto) {
		return modelMapper.map(compteDto, Compte.class);
	}

	public static List<Compte> convertDtoListToCompteList(List<CompteDto> compteDtoList) {
		List<Compte> result = new ArrayList<>();
		for (CompteDto compteDto : compteDtoList) {
			result.add(convertDtoToCompte(compteDto));
		}
		return result;
	}

	public static List<CompteDto> CompteListToconvertDtoList(List<Compte> compteList) {
		List<CompteDto> result = new ArrayList<>();
		for (Compte compte : compteList) {
			result.add(convertCompteToDto(compte));
		}
		return result;
	}

}
