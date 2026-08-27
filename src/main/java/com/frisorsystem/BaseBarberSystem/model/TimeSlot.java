package com.frisorsystem.BaseBarberSystem.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeSlotID")
    private Long id;
    private LocalDate date;
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
