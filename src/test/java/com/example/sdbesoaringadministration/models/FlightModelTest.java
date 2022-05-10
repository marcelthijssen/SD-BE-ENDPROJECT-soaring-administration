package com.example.sdbesoaringadministration.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightModelTest {

    private Flight flight;

    @BeforeEach
    void setUp() {
        this.flight = new Flight();
        this.flight.setId( 0L );
        this.flight.setInstructionFlight( false );
//        this.flight.setTimeEnd( "2022-04-14 10:00:37" );
//        this.flight.setTimeEnd( "2022-04-14 10:00:37" );
        this.flight.setTimeFlown( 12L );
        this.flight.setRemarks( "some remarks" );
    }


    @Test
    void testShouldReturn_ID() {
        Long expectedResult = 0L;
        Long actualResult = flight.getId();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void testShouldReturn_TimeFlown() {
        Long expectedResult = 12L;
        Long actualResult = flight.getTimeFlown();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void testShouldReturn_remarks() {
        String expectedResult = "some remarks";
        String actualResult = flight.getRemarks();
        assertEquals( expectedResult, actualResult );
    }
}
