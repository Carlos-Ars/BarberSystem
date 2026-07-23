package com.frisorsystem.BaseBarberSystem.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingID")
    private Long id;
    private String status;

    //relation between classes/entities
    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "timeSlotID")
    private TimeSlot timeSlot;


    //empty constructor so the databse can generate values
    public Booking(){
    }

    //constructor
    public Booking (String status, User user, TimeSlot timeSlot){
        this.status = status;
        this.user = user;
        this.timeSlot = timeSlot;
    }


    public Long getId() {
        return id;
    }


    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }

    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user=user;
    }

    public TimeSlot getTimeSlot(){
        return timeSlot;
    }
    public void setTimeSlot(TimeSlot timeSlot){
        this.timeSlot=timeSlot;
    }



}

