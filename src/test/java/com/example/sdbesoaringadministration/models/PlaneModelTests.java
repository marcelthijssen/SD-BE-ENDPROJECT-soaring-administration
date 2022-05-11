package com.example.sdbesoaringadministration.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaneModelTests {

    private Plane plane;

    @BeforeEach
    void setUp() {
        plane = new Plane();
        plane.setId( 1L );
        plane.setCallSign( "3G" );
        plane.setBrand( "Brand" );
        plane.setType( "Type" );
        plane.setRegistration( "PH-1234" );
        plane.setTwoSeater( false );
        plane.setPrivatePlane( false );
        plane.setMinutePrice( BigDecimal.valueOf( 0.25 ) );
    }

    @Test
    void shouldReturnId() {
        Long expectedResult = ( 1L );
        Long actualResult = plane.getId();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnCallSign() {
        String expectedResult = ( "3G" );
        String actualResult = plane.getCallSign();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnBrand() {
        String expectedResult = ( "Brand" );
        String actualResult = plane.getBrand();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnType() {
        String expectedResult = ( "Type" );
        String actualResult = plane.getType();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnRegistration() {
        String expectedResult = ( "PH-1234" );
        String actualResult = plane.getRegistration();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnTwoSeater() {
        Boolean expectedResult = ( false );
        Boolean actualResult = plane.getPrivatePlane();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnPrivatePlane() {
        Boolean expectedResult = ( false );
        Boolean actualResult = plane.getPrivatePlane();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnMinutePrice() {
        BigDecimal expectedResult = ( BigDecimal.valueOf( 0.25 ) );
        BigDecimal actualResult = plane.getMinutePrice();
        assertEquals( expectedResult, actualResult );
    }
}