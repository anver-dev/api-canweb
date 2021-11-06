package com.can.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.can.com.model.AdoptionRequest;

public interface AdoptionRequestRepository extends JpaRepository<AdoptionRequest, Long> {

}
