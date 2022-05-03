/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportModelTests {

    private Airport airport;

    @BeforeEach
    void setUp() {
        this.airport = new Airport();
        this.airport.setIcao( "ABCD" );
        this.airport.setCountry( "ACountry" );
        this.airport.setCity( "ACity" );
        this.airport.setId( 1L );
    }

    @Test
    void testGeticao() {
        String expectedResult = "ABCD";
        String actualResult = airport.getIcao();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void testGetCity() {
        String expectedResult = "ACity";
        String actualResult = airport.getCity();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void testGetCountry() {
        String expectedResult = "ACountry";
        String actualResult = airport.getCountry();
        assertEquals( expectedResult, actualResult );
    }

}
