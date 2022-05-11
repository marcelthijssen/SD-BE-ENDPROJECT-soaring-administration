package com.example.sdbesoaringadministration.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    //        ADMIN_ROLE
//    @WithMockUser(value = "ADMIN")
//    @Test
//    public void givenAuthRequestGetAll_shouldSucceedWith200() throws Exception {
//        mvc.perform( get( "/users" ).contentType( MediaType.APPLICATION_JSON ) )
//                .andExpect( status().isOk() );
//    }
//    @WithMockUser(value = "ADMIN")
//    @Test
//    public void givenAuthRequestGetOne_shouldSucceedWith200() throws Exception {
//        mvc.perform( get( "/users/{username}", "username" ).contentType( MediaType.APPLICATION_JSON ) )
//                .andExpect( status().isOk() );
//    }

//    @WithMockUser(value = "ADMIN")
//    @Test
//    public void givenAuthRequestPost_shouldSucceedWith200() throws Exception {
//        mvc.perform( post( "/users" ).contentType( MediaType.APPLICATION_JSON ) )
//                .andExpect( status().isCreated() );
//    }

//    @WithMockUser(value = "ADMIN")
//    @Test
//    public void givenAuthRequestDelete_shouldSucceedWith200() throws Exception {
//        mvc.perform( delete( "/users/{username}", "username" ).contentType( MediaType.APPLICATION_JSON ) )
//            .andExpect( status().isOk());
//    }

    //        USER_ROLE
    @WithMockUser(value = "USER")
    @Test
    public void givenAuthRequestGet_shouldSucceedWith403() throws Exception {
        mvc.perform( get( "/users" ).contentType( MediaType.APPLICATION_JSON ) )
                .andExpect( status().is4xxClientError() );
    }
}
