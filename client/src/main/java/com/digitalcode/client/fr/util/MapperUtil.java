package com.digitalcode.client.fr.util;

import org.modelmapper.ModelMapper;

import com.digitalcode.client.fr.entity.dto.ClientDto;
import com.digitalcode.client.fr.entity.jpa.Client;

public class MapperUtil {

	private static ModelMapper modelMapper = new ModelMapper();
	
	public static ClientDto convertClientToDto(Client clientDto) {
		return modelMapper.map(clientDto, ClientDto.class);
	}
	
	public static Client convertDtoTOClient(ClientDto client) {
		return modelMapper.map(client, Client.class);
	}
}
