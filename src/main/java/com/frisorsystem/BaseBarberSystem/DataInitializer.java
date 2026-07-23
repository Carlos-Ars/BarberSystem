package com.frisorsystem.BaseBarberSystem;

import com.frisorsystem.BaseBarberSystem.model.User;
import com.frisorsystem.BaseBarberSystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {

        User user = new User();
        user.setName("Test");
        user.setPhone("0700000000");
        user.setRole("CUSTOMER");

        userRepository.save(user);

        System.out.println("User sparad!");
    }
}

