package com.example.sdbesoaringadministration.controllers;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@WebMvcTest
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FlightControllerTests {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void flightControllerGetAllFlightsTest() throws JSONException {

        String response = this.restTemplate.getForObject( "/flights", String.class );

        JSONAssert.assertEquals( "[{id:6001},{id:6002}]",
                response, false );
    }
}