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

import lombok.Data;

@Data
@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String name;
	
	private int age;
	
	@NotNull
	private String status;
	
	@NotNull
	private String pathImg;
	
	@OneToOne
	private Center center;
	
	@NotNull
	@OneToMany
	@JoinTable(name = "pet_adoptionrequest", 
	joinColumns = @JoinColumn(name = "pet_id"))
	private Set<AdoptionRequest> adoptionRequests = new HashSet<>();
	
	public Pet() {}
	
	public Pet(@NotNull String name, int age, @NotNull String status, @NotNull String pathImg) {
		super();
		this.name = name;
		this.age = age;
		this.status = status;
		this.pathImg = pathImg;
	}
}
