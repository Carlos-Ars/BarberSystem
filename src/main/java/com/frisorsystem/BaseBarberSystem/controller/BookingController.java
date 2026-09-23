package com.frisorsystem.BaseBarberSystem.controller;


import com.frisorsystem.BaseBarberSystem.model.Booking;
import com.frisorsystem.BaseBarberSystem.repository.BookingRepository;
import com.frisorsystem.BaseBarberSystem.repository.TimeSlotRepository;
import com.frisorsystem.BaseBarberSystem.model.TimeSlot;
import com.frisorsystem.BaseBarberSystem.dto.UpdateBookingRequest;

import com.frisorsystem.BaseBarberSystem.exception.BadRequestException;
import com.frisorsystem.BaseBarberSystem.exception.NotFoundException;

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
        return bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found"));
    }

    // Create new bookings
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){

        if (bookingRepository.existsByTimeSlotId(booking.getTimeSlot().getId())) {
            throw new RuntimeException("Time slot is already booked");
        }

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
                .orElseThrow(() -> new NotFoundException("Booking not found"));


        booking.setStatus(request.getStatus());


        TimeSlot timeSlot = timeSlotRepository.findById(request.getTimeSlotId())
                .orElseThrow(() -> new NotFoundException("Time slot not found"));

        if (bookingRepository.existsByTimeSlotIdAndIdNot(timeSlot.getId(), id)) {
            throw new BadRequestException("Time slot is already booked");
        }


        booking.setTimeSlot(timeSlot);


        return bookingRepository.save(booking);
    }


}