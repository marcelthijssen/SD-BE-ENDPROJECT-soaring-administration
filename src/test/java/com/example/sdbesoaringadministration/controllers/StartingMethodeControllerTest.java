package com.example.sdbesoaringadministration.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StartingMethodeControllerTest {
    @Autowired
    private MockMvc mvc;

//    ADMIN_ROLE
    @WithMockUser(value = "ADMIN")
    @Test
    public void givenAuthRequestAdminGet_shouldSucceedWith200() throws Exception {
        mvc.perform( get( "/startingmethodes" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }

//    @WithMockUser(value = "ADMIN")
//    @Test
//    public void givenAuthRequestAdminDelete_shouldSucceedWith200() throws Exception {
//        mvc.perform( delete( "/startingmethodes/2001" ).contentType( MediaType.APPLICATION_JSON ) )
//                .andExpect( status().isOk() );
//    }



    //    USER_ROLE
    @WithMockUser(value = "USER")
    @Test
    public void givenAuthRequestUserGet_shouldSucceedWith200() throws Exception {
        mvc.perform( get( "/startingmethodes" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().isOk() );
    }
}
