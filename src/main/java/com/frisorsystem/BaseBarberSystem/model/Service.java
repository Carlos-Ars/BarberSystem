package com.frisorsystem.BaseBarberSystem.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serviceID")
    private Long id;

    @Positive
    private int durationMinutes;

    @NotBlank
    private String serviceName;

    @Positive
    private BigDecimal price;


    public Service(){
    }

    public Service (int durationMinutes, String serviceName, BigDecimal price){
        this.durationMinutes=durationMinutes;
        this.serviceName=serviceName;
        this.price=price;
    }

    public Long getId(){
        return id;
    }

    public int getDurationMinutes(){
        return durationMinutes;
    }
    public void setDurationMinutes (int durationMinutes){
        this.durationMinutes=durationMinutes;
    }


    public String getServiceName(){
        return serviceName;
    }
    public void setServiceName (String serviceName){
        this.serviceName=serviceName;
    }

    public BigDecimal getPrice(){
        return price;
    }
    public void setPrice (BigDecimal price){
        this.price=price;
    }

}
