package com.can.com.security.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class JwtDto {
	private String token;
	private String bearer;
	private String username;
	private Long id;
	private Collection<? extends GrantedAuthority> authorities;
	
	public JwtDto(String token, String username, Long id,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.token = token;
		this.bearer = "Bearer";
		this.username = username;
		this.id = id;
		this.authorities = authorities;
	}
}
