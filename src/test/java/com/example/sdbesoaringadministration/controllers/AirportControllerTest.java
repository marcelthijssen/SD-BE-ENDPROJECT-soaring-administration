package com.example.sdbesoaringadministration.controllers;

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

    @WithMockUser(value = "USER")
    @Test
    public void givenAuthRequestGet_shouldSucceedWith200() throws Exception {
        mvc.perform( get( "/airports" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }

//    @WithMockUser(value = "USER")
//    @Test
//    public void givenAuthRequestPost_shouldSucceedWith200() throws Exception {
//        mvc.perform( post( "/airports" ).contentType( MediaType.APPLICATION_JSON ) )
//                .andExpect( status().isOk() );
//    }

    @WithMockUser(value = "USER")
    @Test
    public void givenAuthRequestDelete_shouldNotSucceedWith403() throws Exception {
        mvc.perform( delete( "/airports" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().is4xxClientError() );
    }

}
