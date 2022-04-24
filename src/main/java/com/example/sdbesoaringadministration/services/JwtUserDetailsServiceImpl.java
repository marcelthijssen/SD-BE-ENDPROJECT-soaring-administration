package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.AUserDto;
import com.example.sdbesoaringadministration.models.AUser;
import com.example.sdbesoaringadministration.repositories.AUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AUserRepository aUserRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        AUser user = aUserRepository.findByUsername( username );
        if ( user == null ) {
            throw new UsernameNotFoundException( "User not found with username: " + username );
        }
        return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(),
                new ArrayList<>() );
    }

    public AUser save( AUserDto dto ) {
        AUser auser = new AUser();
        auser.setUsername( dto.getUsername() );
        auser.setPassword( bcryptEncoder.encode( dto.getPassword() ) );
        return aUserRepository.save( auser );
    }
}