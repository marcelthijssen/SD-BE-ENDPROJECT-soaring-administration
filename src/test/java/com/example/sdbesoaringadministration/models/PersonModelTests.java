/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Test for Person.classe
 */

package com.example.sdbesoaringadministration.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonModelTests {

    private Person person;

    @BeforeEach
    void setUp() {
        this.person = new Person();
        this.person.setId( 1L );
        this.person.setGender( "m" );
        this.person.setFirstName( "Firstname" );
        this.person.setLastName( "Lastname" );
        this.person.setDateOfBirth( LocalDate.of( 1879, 3, 14 ) );
        this.person.setStreetName( "Streetname" );

        this.person.setHouseNumber( "12" );
        this.person.setPostalcode( "9876ZY" );
        this.person.setCity( "City" );
        this.person.setCountry( "Country" );
        this.person.setEmail( "this@email.nl" );
        this.person.setPhone( "0123654789" );
        this.person.setPilotLicense( true );
        this.person.setMembership( person.getMembership() );
    }

    @Test
    void shouldReturnId() {
        Long expected = 1L;
        Long actual = this.person.getId();
        assertEquals( expected, actual );
    }

    @Test
    void ShouldReturnGender() {
        String expected = ( "m" );
        String actual = person.getGender();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnFirstName() {
        String expected = "Firstname";
        String actual = this.person.getFirstName();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnLastName() {
        String expected = "Lastname";
        String actual = this.person.getLastName();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnDateOfBirth ( ) {
        LocalDate expected = LocalDate.of( 1879, 3, 14 );
        LocalDate actual = this.person.getDateOfBirth();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnStreetname() {
        String expected = "Streetname";
        String actual = this.person.getStreetName();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnHouseNumber() {
        String expected = "12";
        String actual = this.person.getHouseNumber();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnPostalCode() {
        String expected = "9876ZY";
        String actual = this.person.getPostalcode();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnCity() {
        String expected = "City";
        String actual = this.person.getCity();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnCountry() {
        String expected = "Country";
        String actual = this.person.getCountry();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnEmail() {
        String expected = "this@email.nl";
        String actual = this.person.getEmail();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnPhone() {
        String expected = "0123654789";
        String actual = this.person.getPhone();
        assertEquals( expected, actual );
    }

    @Test
    void shouldReturnPilotLicense() {
        Boolean expected = true;
        Boolean actual = this.person.getPilotLicense();
        assertEquals( expected, actual );
    }

}
