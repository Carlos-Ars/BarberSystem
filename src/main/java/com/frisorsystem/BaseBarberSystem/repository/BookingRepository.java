package com.frisorsystem.BaseBarberSystem.repository;

import com.frisorsystem.BaseBarberSystem.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    boolean existsByTimeSlotId(Long timeSlotId);

    boolean existsByTimeSlotIdAndIdNot(Long timeSlotId, Long bookingId);
}