package com.frisorsystem.BaseBarberSystem.model;

import jakarta.persistence.*;


@Entity

public class BookingService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookingServiceID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bookingID")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "serviceID")
    private Service service;

    public BookingService() {}

    public BookingService(Booking booking, Service service) {
        this.booking = booking;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}





