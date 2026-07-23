package com.frisorsystem.BaseBarberSystem.repository;



import com.frisorsystem.BaseBarberSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}