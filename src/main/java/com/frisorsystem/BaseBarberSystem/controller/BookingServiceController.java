

package com.frisorsystem.BaseBarberSystem.controller;

import com.frisorsystem.BaseBarberSystem.model.BookingService;
import com.frisorsystem.BaseBarberSystem.repository.BookingServiceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/booking-services")
public class BookingServiceController {

    private final BookingServiceRepository bookingServiceRepository;

    public BookingServiceController(BookingServiceRepository bookingServiceRepository){
        this.bookingServiceRepository = bookingServiceRepository;
    }

    // Get all booking services
    @GetMapping
    public List<BookingService> getAllBookingServices(){
        return bookingServiceRepository.findAll();
    }

    // Create booking service
    @PostMapping
    public BookingService createBookingService(@RequestBody BookingService bookingService){
        return bookingServiceRepository.save(bookingService);
    }

}