package com.can.com.security.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.can.com.security.enums.RolName;
import com.can.com.security.model.Rol;
import com.can.com.security.repository.RolRepository;

@Service
@Transactional
public class RolService {
	
	@Autowired
	private RolRepository rolRepository;
	
	public Optional<Rol> getRolByName(RolName name) {
		return rolRepository.findByName(name);
	}

	public void save(Rol rol) {
		rolRepository.save(rol);
		
	}
}
