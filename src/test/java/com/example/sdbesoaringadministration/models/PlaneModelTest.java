package com.example.sdbesoaringadministration.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaneModelTest {

    private Plane plane;
    
    @BeforeEach
    void setUp() {
        this.plane = new Plane();
        this.plane.setId( 0L );
        this.plane.setRegistration( "PH1234" );
        this.plane.setCallSign( "K8" );
        this.plane.setBrand( "Brand" );
        this.plane.setType( "type" );
        this.plane.setPrivatePlane( false );
        this.plane.setTwoSeater( true );
        this.plane.setMinutePrice( BigDecimal.valueOf( 1.25 ) );
    }

    @Test
    void shouldReturnId() {
        Long expectedResult = 0L;
        Long actualResult = plane.getId();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnRegistration() {
        String expectedResult = "PH1234";
        String actualResult = plane.getRegistration();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnCallSign() {
        String expectedResult = "K8";
        String actualResult = plane.getCallSign();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnBrand() {
        String expectedResult = "Brand";
        String actualResult = plane.getBrand();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnType() {
        String expectedResult = "type";
        String actualResult = plane.getType();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnPrivatePlan() {
        boolean expectedResult = false;
        boolean actualResult = plane.getPrivatePlane();
        assertEquals( expectedResult, actualResult );
    }
    @Test
    void shouldReturnTwoSeater() {
        boolean expectedResult = true;
        boolean actualResult = plane.getTwoSeater();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnMinutePrice() {
        BigDecimal expectedResult = BigDecimal.valueOf( 1.25 );
        BigDecimal actualResult = plane.getMinutePrice();
        assertEquals( expectedResult, actualResult );
    }


}
