package com.example.sdbesoaringadministration.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTests {


    private Person person;

    @BeforeEach
    void setUp() {
        this.person = new Person();
        this.person.setPhone( "0123654789" );
        this.person.setDateOfBirth( LocalDate.of( 1879, 3, 14));
    }

    @Test
    void testGetPhone() {
        String expectedPhone = "0123654789";
        String actualPhone = this.person.getPhone();
        assertEquals(expectedPhone, actualPhone);
    }

    @Test
    void testGetDateOfBirth() {
        LocalDate expectedDateOfBirth = LocalDate.of( 1879, 3, 14);
        LocalDate actualDateOfBirth = person.getDateOfBirth();
        assertEquals(expectedDateOfBirth, actualDateOfBirth);
    }

}
