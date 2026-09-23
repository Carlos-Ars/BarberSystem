

package com.frisorsystem.BaseBarberSystem.controller;
import com.frisorsystem.BaseBarberSystem.model.User;
import com.frisorsystem.BaseBarberSystem.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import com.frisorsystem.BaseBarberSystem.exception.NotFoundException;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {


    private final UserRepository userRepository;


    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    // Get all users
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    // Get user by id
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }


    // Create user
    @PostMapping
    public User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }


    // Update user
    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody User updatedUser
    ){

        User user = userRepository.findById(id)
                .orElseThrow();


        user.setName(updatedUser.getName());
        user.setPhone(updatedUser.getPhone());
        user.setRole(updatedUser.getRole());


        return userRepository.save(user);
    }


    // Delete user
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}



