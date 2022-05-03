package com.example.sdbesoaringadministration.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {

private User user;

    @BeforeEach
    void setUp() {
        this.user = new User();
        this.user.setUsername( "Username" );
        this.user.setEmail( "this@email.nl" );
        this.user.setEnabled( true );
    }

    @Test
    void shouldReturnUsername() {
        String expectedResult = ( "Username" );
        String actualResult = user.getUsername();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnEmail() {
        String expectedResult = ( "this@email.nl" );
        String actualResult = user.getEmail();
        assertEquals( expectedResult, actualResult );
    }

    @Test
    void shouldReturnEnabled() {
        boolean expectedResult = ( true );
        boolean actualResult = user.getEnabled();
        assertEquals( expectedResult, actualResult );
    }
}