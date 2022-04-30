package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.models.User;
import com.example.sdbesoaringadministration.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest
public class FlightServiceImplTests {

@InjectMocks
private FlightServiceImpl flightServiceImpl;
    @Mock
    FlightService service;

    @Mock
    UserRepository userRepository;
    @Mock
    User user;
    @Mock
    Authentication authentication;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void flightService_shouldCalculateTimeFlown() {
        Flight flightTest = new Flight();
        flightTest.setTimeStart( LocalDateTime.parse( "2022-04-26T07:42:32.341225" ) );
//        System.out.println(flightTest.getTimeStart());
        flightTest.setTimeEnd( LocalDateTime.parse( "2022-04-26T09:42:32.341225" ) );
//        System.out.println(flightTest.getTimeEnd());

        assertEquals( 120, flightServiceImpl.calculateTimeFlown( flightTest.getTimeStart(), flightTest.getTimeEnd() ) );

    }
}


