package com.digitalcode.compte.fr.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Client {
	
	private Long id;

	private String firstName;
	
    private String lastName;
	
	private String email; 
}
