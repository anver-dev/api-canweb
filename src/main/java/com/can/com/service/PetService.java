package com.can.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.can.com.model.Pet;
import com.can.com.repository.PetRepository;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public List<Pet> getAll() {
		return petRepository.findAll();
	}
	
	public Pet getPetById(Long id) {
		return petRepository.getById(id);
	}

	public Pet save(Pet pet) {
		return petRepository.save(pet);
		
	}
}
