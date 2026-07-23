package com.frisorsystem.BaseBarberSystem.repository;


import com.frisorsystem.BaseBarberSystem.model.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingServiceRepository extends JpaRepository<BookingService, Long> {
}
