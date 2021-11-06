package com.can.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.can.com.model.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
	
}
