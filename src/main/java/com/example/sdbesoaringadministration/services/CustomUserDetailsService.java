/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Implements methodes for USerDetaislService
 *
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.UserDto;
import com.example.sdbesoaringadministration.exceptions.UsernameNotFoundException;
import com.example.sdbesoaringadministration.models.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername( String username ) {
        Optional<UserDto> user = Optional.ofNullable( userService.getUserById( username ) );
        if ( !user.isPresent() ) {
            throw new UsernameNotFoundException( HttpStatus.NOT_FOUND, username );
        }

        String password = user.get().getPassword();

        Set<Authority> authorities = user.get().getAuthorities();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for ( Authority authority : authorities ) {
            grantedAuthorities.add( new SimpleGrantedAuthority( authority.getAuthority() ) );
        }

        return new org.springframework.security.core.userdetails.User( username, password, grantedAuthorities );
    }

}