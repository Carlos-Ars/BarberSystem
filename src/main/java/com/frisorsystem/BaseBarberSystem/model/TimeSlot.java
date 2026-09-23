package com.frisorsystem.BaseBarberSystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeSlotID")
    private Long id;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalTime time;



    public TimeSlot(){
    }

    public TimeSlot (LocalDate date, LocalTime time){
        this.date=date;
        this.time=time;
    }



    public Long getId(){
        return id;
    }

    public LocalDate getDate(){
        return date;
    }
    public void setDate(LocalDate date){
        this.date=date;
    }

    public LocalTime getTime(){
        return time;
    }
    public void setTime(LocalTime time){
        this.time=time;
    }




}
