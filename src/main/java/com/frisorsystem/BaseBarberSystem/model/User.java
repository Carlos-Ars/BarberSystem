package com.frisorsystem.BaseBarberSystem.model;

import jakarta.validation.constraints.NotBlank;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank
    private String role;

    public User(){
    }

    public User (String name, String phone, String role){
        this.name=name;
        this.phone=phone;
        this.role=role;
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public void setName (String name){
        this.name=name;
    }


    public String getPhone(){
        return phone;
    }
    public void setPhone (String phone){
        this.phone=phone;
    }

    public String getRole(){
        return role;
    }
    public void setRole (String role){
        this.role=role;
    }

}
