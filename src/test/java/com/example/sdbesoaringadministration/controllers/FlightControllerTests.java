package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.services.FlightServiceImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FlightControllerTests {


    MockMvc mockMvc;

    @MockBean
    FlightServiceImpl mockService;

    @Test
    public void shouldReturnOrder() throws Exception {
Flight flight = new Flight();
flight.setId( 1L );
        flight.setTimeStart( LocalDateTime.parse( "2022-04-26T07:42:32.341225" ) );
        flight.setTimeEnd( LocalDateTime.parse( "2022-04-26T09:42:32.341225" ) );
        Mockito.when(mockService.calculateTimeFlown(flight.getTimeStart(), flight.getTimeEnd())).thenReturn( 120L );

        mockMvc.perform(put("/flight/1/end"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("order with number 123")));
    }
}
//
//    void shouldReturnTimeFlown() {
//        flight.setTimeStart( LocalDateTime.parse( "2022-04-26T07:42:32.341225" ) );
//        flight.setTimeEnd( LocalDateTime.parse( "2022-04-26T09:42:32.341225" ) );
//        assertEquals( 120, flightServiceImpl.calculateTimeFlown( flight.getTimeStart(), flight.getTimeEnd() ) );
//
//    }