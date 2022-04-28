package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.payload.AuthenticationRequest;
import com.example.sdbesoaringadministration.payload.AuthenticationResponse;
import com.example.sdbesoaringadministration.services.CustomUserDetailsService;
import com.example.sdbesoaringadministration.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private
    CustomUserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtl;

    @GetMapping(value = "/authenticated")
    public ResponseEntity<Object> authenticated( Authentication authentication, Principal principal ) {
        return ResponseEntity.ok().body( principal );
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken( @RequestBody AuthenticationRequest authenticationRequest ) throws Exception {

        String username = authenticationRequest.getUsername();
        String password = authenticationRequest.getPassword();

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( username, password )
            );
        } catch ( BadCredentialsException ex ) {
            throw new Exception( "Incorrect username or password", ex );
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername( username );

        final String jwt = jwtUtl.generateToken( userDetails );

        return ResponseEntity.ok( new AuthenticationResponse( jwt ) );
    }

}
