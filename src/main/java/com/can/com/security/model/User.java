package com.can.com.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.can.com.model.AdoptionRequest;
import com.can.com.model.Ubication;

import lombok.Data;

@Data
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Column(unique = true)
	private String username;

	@NotNull
	private String email;

	@NotNull
	private String password;
	
	@OneToOne
	private Ubication ubication;
	
	private String pathImgProfile;
	
	@NotNull
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_rol", 
		joinColumns = @JoinColumn(name = "user_id"), 
		inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<Rol>();
	
	@OneToMany
	@JoinTable(name = "user_adoptionrequest", 
		joinColumns = @JoinColumn(name = "user_id"))
	private Set<AdoptionRequest> adoptionRequests = new HashSet<>();
	
	public User() {}	
	
	public User(@NotNull String name, @NotNull String username, @NotNull String email, @NotNull String password) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	
	
}
