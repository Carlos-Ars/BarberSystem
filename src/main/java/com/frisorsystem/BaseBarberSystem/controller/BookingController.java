package com.frisorsystem.BaseBarberSystem.controller;


import com.frisorsystem.BaseBarberSystem.model.Booking;
import com.frisorsystem.BaseBarberSystem.repository.BookingRepository;
import com.frisorsystem.BaseBarberSystem.repository.TimeSlotRepository;
import com.frisorsystem.BaseBarberSystem.model.TimeSlot;
import com.frisorsystem.BaseBarberSystem.dto.UpdateBookingRequest;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/bookings")


public class BookingController {


    private final BookingRepository bookingRepository;
    private final TimeSlotRepository timeSlotRepository;


    public BookingController(BookingRepository bookingRepository,
                             TimeSlotRepository timeSlotRepository){
        this.bookingRepository = bookingRepository;
        this.timeSlotRepository = timeSlotRepository;
    }


    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

    // Get booking by id
    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id){
        return bookingRepository.findById(id).orElse(null);
    }

    // Create new bookings
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingRepository.save(booking);
    }

    // Delete booking
    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
    }


    // Update booking
    @PutMapping("/{id}")
    public Booking updateBooking(
            @PathVariable Long id,
            @RequestBody UpdateBookingRequest request
    ){

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));


        booking.setStatus(request.getStatus());


        TimeSlot timeSlot = timeSlotRepository.findById(request.getTimeSlotId())
                .orElseThrow(() -> new RuntimeException("Time slot not found"));


        booking.setTimeSlot(timeSlot);


        return bookingRepository.save(booking);
    }


}