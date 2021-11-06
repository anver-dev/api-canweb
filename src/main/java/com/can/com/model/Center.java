package com.can.com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.can.com.security.model.User;

import lombok.Data;

@Data
@Entity
public class Center {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	@NotNull
	@OneToOne
	private User user;

	@NotNull
	@OneToMany
	@JoinTable(name = "center_pet", 
	joinColumns = @JoinColumn(name = "center_id"))
	private Set<Pet> pets = new HashSet<>();
	
	@NotNull
	@OneToMany
	@JoinTable(name = "center_comment", 
	joinColumns = @JoinColumn(name = "center_id"))
	private Set<Comment> comments = new HashSet<>();
	
	public Center() { }
	
	public Center(@NotNull User user, @NotNull Set<Pet> pets) {
		super();
		this.user = user;
		this.pets = pets;
	}



	
}
