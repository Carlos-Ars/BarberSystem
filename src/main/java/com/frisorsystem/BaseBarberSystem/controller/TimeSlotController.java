

package com.frisorsystem.BaseBarberSystem.controller;

import com.frisorsystem.BaseBarberSystem.model.TimeSlot;
import com.frisorsystem.BaseBarberSystem.repository.TimeSlotRepository;
import org.springframework.web.bind.annotation.*;

import com.frisorsystem.BaseBarberSystem.exception.NotFoundException;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/timeslots")


public class TimeSlotController {

    private final TimeSlotRepository timeSlotRepository;
    

    public TimeSlotController(TimeSlotRepository timeSlotRepository){
        this.timeSlotRepository = timeSlotRepository;
    }


    // Get all time slots
    @GetMapping
    public List<TimeSlot> getAllTimeSlots(){
        return timeSlotRepository.findAll();
    }


    // Get time slot by id
    @GetMapping("/{id}")
    public TimeSlot getTimeSlotById(@PathVariable Long id){
        return timeSlotRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Time slot not found"));
    }


    // Create new time slot
    @PostMapping
    public TimeSlot createTimeSlot(@Valid @RequestBody TimeSlot timeSlot){
        return timeSlotRepository.save(timeSlot);
    }


    // Delete time slot
    @DeleteMapping("/{id}")
    public void deleteTimeSlot(@PathVariable Long id){
        timeSlotRepository.deleteById(id);
    }

}