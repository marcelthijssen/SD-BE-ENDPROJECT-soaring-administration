package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.models.Airport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AirportControllerTest {

    @Autowired
    private MockMvc mvc;


    @BeforeEach
    void setUp() {
        Airport airport = new Airport();
        airport.setIcao( "ABCD" );
        airport.setCountry( "ACountry" );
        airport.setCity( "ACity" );
        airport.setId( 1L );
    }
    //    ADMIN_ROLE

    @WithMockUser(value = "ADMIN")
    @Test
    public void givenAuthRequestAdminDelete_shouldSucceedWith200() throws Exception {
        mvc.perform( delete( "/airports/1001" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }

    @WithMockUser(value = "ADMIN")
    @Test
    public void givenAuthRequestAdminGet_shouldSucceedWith200() throws Exception {
        mvc.perform( get( "/airports" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }

    @WithMockUser(value = "ADMIN")
    @Test
    public void givenAuthRequestAdminGetOne_shouldSucceedWith200() throws Exception {
        mvc.perform( get( "/airports/1001" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }

    //    USER_ROLE

    @WithMockUser(value = "USER")
    @Test
    public void givenAuthRequestUserGetAll_shouldSucceedWith200() throws Exception {
        mvc.perform( get( "/airports" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }

    @WithMockUser(value = "ADMIN")
    @Test
    public void givenAuthRequestUserGetOne_shouldSucceedWith200() throws Exception {
        mvc.perform( get( "/airports/1001" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }

    @WithMockUser(value = "USER")
    @Test
    public void givenAuthRequestPost_shouldSucceedWith200() throws Exception {
        mvc.perform( post( "/airports" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }


    @WithMockUser(value = "USER")
    @Test
    public void givenAuthRequestUserPut_shouldSucceedWith200() throws Exception {
        mvc.perform( put( "/airports/1001" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }

    @WithMockUser(value = "USER")
    @Test
    public void givenAuthRequestUserDelete_shouldNotSucceedWith403() throws Exception {
        mvc.perform( delete( "/airports" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().is4xxClientError() );
    }


}
