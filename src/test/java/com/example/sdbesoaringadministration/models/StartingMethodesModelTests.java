/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Purpos of this class
 */
package com.example.sdbesoaringadministration.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartingMethodesModelTests {
    private StartingMethode startingMethode;

    @BeforeEach
    void setUp() {
        this.startingMethode = new StartingMethode();
        this.startingMethode.setPrice( BigDecimal.valueOf( 10 ) );
        this.startingMethode.setTitle( "testing" );
        this.startingMethode.setUnit( "unit" );
        this.startingMethode.setId( 1L );

        List<StartingMethode> smList = new ArrayList<>();
        smList.add(startingMethode);
    }

    @Test
    void shouldReturnId() {
        Long expectedResult = 1L;
        Long actualResult = startingMethode.getId();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnTitle() {
        String expectedResult = "testing";
        String actualResult = startingMethode.getTitle();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnPrice() {
        BigDecimal expectedResult = BigDecimal.valueOf( 10 );
        BigDecimal actualResult = startingMethode.getPrice();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void testGetCountry() {
        String expectedResult = "unit";
        String actualResult = startingMethode.getUnit();
        assertEquals( expectedResult, actualResult );
    }

}
