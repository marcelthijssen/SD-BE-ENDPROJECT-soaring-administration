package com.example.sdbesoaringadministration.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MembershipModelTest {

    private Membership membership;

    @BeforeEach
    void setUp() {
        this.membership = new Membership();
        this.membership.setId( 0L );
        this.membership.setTitle( "title" );
        this.membership.setCostsPerMonth( BigDecimal.valueOf( 12 ) );
    }

    @Test
    void shouldReturnId() {
        Long expectedResult = 0L;
        Long actualResult = membership.getId();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnTitle() {
        String expectedResult = "title";
        String actualResult = membership.getTitle();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnCostPerMonth() {
        BigDecimal expectedResult = BigDecimal.valueOf( 12 );
        BigDecimal actualResult = membership.getCostsPerMonth();
        assertEquals( expectedResult, actualResult );
    }
}
