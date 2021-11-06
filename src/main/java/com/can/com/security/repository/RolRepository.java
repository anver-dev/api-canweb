package com.can.com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.can.com.security.enums.RolName;
import com.can.com.security.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
	Optional<Rol> findByName(RolName name);
}
