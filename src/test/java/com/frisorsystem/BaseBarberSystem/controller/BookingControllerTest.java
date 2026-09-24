

package com.frisorsystem.BaseBarberSystem.controller;




import com.frisorsystem.BaseBarberSystem.repository.BookingRepository;

import com.frisorsystem.BaseBarberSystem.repository.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.frisorsystem.BaseBarberSystem.model.Booking;
import com.frisorsystem.BaseBarberSystem.model.TimeSlot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookingControllerTest {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Test
    void alreadyBookedTimeSlotShouldBeDetected() {

        TimeSlot timeSlot = new TimeSlot(
                java.time.LocalDate.of(2030, 1, 1),
                java.time.LocalTime.of(10, 0)
        );

        timeSlotRepository.save(timeSlot);

        Booking booking = new Booking();
        booking.setStatus("CONFIRMED");
        booking.setTimeSlot(timeSlot);

        bookingRepository.save(booking);

        boolean alreadyBooked =
                bookingRepository.existsByTimeSlotId(timeSlot.getId());

        assertTrue(alreadyBooked);

        bookingRepository.delete(booking);
        timeSlotRepository.delete(timeSlot);
    }
}