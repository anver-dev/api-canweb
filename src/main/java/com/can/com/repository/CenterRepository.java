package com.can.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.can.com.model.Center;

@Repository
public interface CenterRepository extends JpaRepository<Center, Long> {
}
