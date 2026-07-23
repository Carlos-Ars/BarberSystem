package com.frisorsystem.BaseBarberSystem.controller;


import com.frisorsystem.BaseBarberSystem.model.Booking;
import com.frisorsystem.BaseBarberSystem.repository.BookingRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/bookings")


public class BookingController {


    private final BookingRepository bookingRepository;


    public BookingController(BookingRepository bookingRepository){
        this.bookingRepository = bookingRepository;
    }


    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }


    // Create new bookings
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking){
        return bookingRepository.save(booking);
    }

}