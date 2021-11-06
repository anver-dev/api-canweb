package com.can.com.security.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.can.com.security.model.Rol;

import lombok.Data;

@Data
public class NewUser {
	
	@NotBlank
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String username;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String password;
	
	private Set<Rol> roles = new HashSet<Rol>(); 
}
