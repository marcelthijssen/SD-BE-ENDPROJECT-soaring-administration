package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.config.JwtTokenUtil;
import com.example.sdbesoaringadministration.dtos.UserDto;
import com.example.sdbesoaringadministration.security.JwtRequest;
import com.example.sdbesoaringadministration.security.JwtResponse;
import com.example.sdbesoaringadministration.services.JwtUserDetailsServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    //    @Autowired
    private final AuthenticationManager authenticationManager;

    //    @Autowired
    private final JwtTokenUtil jwtTokenUtil;

    //    @Autowired
    private final JwtUserDetailsServiceImpl jwtUserDetailsService;

    public AuthenticationController( AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, JwtUserDetailsServiceImpl jwtUserDetailsService ) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken( @RequestBody JwtRequest authenticationRequest ) throws Exception {

        authenticate( authenticationRequest.getUsername(), authenticationRequest.getPassword() );

        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername( authenticationRequest.getUsername() );

        final String token = jwtTokenUtil.generateToken( userDetails );

        return ResponseEntity.ok( new JwtResponse( token ) );
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUser( @RequestBody UserDto dto ) throws Exception {
        return ResponseEntity.ok( jwtUserDetailsService.save( dto ) );
    }

    private void authenticate( String username, String password ) throws Exception {
        try {
            authenticationManager.authenticate( new UsernamePasswordAuthenticationToken( username, password ) );
        } catch ( DisabledException e ) {
            throw new Exception( "USER_DISABLED", e );
        } catch ( BadCredentialsException e ) {
            throw new Exception( "INVALID_CREDENTIALS", e );
        }
    }
}