package com.frisorsystem.BaseBarberSystem.repository;

import com.frisorsystem.BaseBarberSystem.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<Service, Long> {
}
