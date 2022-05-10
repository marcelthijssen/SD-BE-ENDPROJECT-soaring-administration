//package com.example.sdbesoaringadministration.controllers;
//
//import com.example.sdbesoaringadministration.services.CustomUserDetailsService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest
//public class AuthenticationControllerTest {
//    @Autowired(required = false)
//    private com.example.sdbesoaringadministration.services.CustomUserDetailsService CustomUserDetailsService;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void shouldReturn200() throws Exception {
//        mockMvc.perform( post( "/authenticate" ) )
//                .andExpect( status().isOk() );
//    }
//}
