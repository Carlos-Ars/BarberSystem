
package com.frisorsystem.BaseBarberSystem.controller;

import com.frisorsystem.BaseBarberSystem.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserControllerTest {

    @Test
    void userCanBeCreated() {

        User user = new User(
                "Test Kund",
                "0701234567",
                "CUSTOMER"
        );

        assertEquals("Test Kund", user.getName());
        assertEquals("0701234567", user.getPhone());
        assertEquals("CUSTOMER", user.getRole());
    }




    @Test
    void userWithEmptyFieldsIsInvalid() {

        User user = new User(
                "",
                "",
                ""
        );

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        var violations = validator.validate(user);

        assertFalse(violations.isEmpty());
    }


}