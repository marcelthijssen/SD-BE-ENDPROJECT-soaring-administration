package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.UserDto;
import com.example.sdbesoaringadministration.models.User;
import com.example.sdbesoaringadministration.repositories.UserRepository;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
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
  private UserRepository userRepo;
    @Autowired
    private PasswordEncoder bcryptEncoder;

    public JwtUserDetailsServiceImpl( UserRepository userRepo, PasswordEncoder bcryptEncoder ) {
        this.userRepo = userRepo;
        this.bcryptEncoder = bcryptEncoder;
    }

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
        User user = userRepo.findByUsername( username );
        if ( user == null ) {
            throw new UsernameNotFoundException( "User not found with username: " + username );
        }
        return new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(),
                new ArrayList<>() );
    }

    public User save( UserDto dto ) {
        User user = new User();
        user.setUsername( dto.getUsername() );
        user.setPassword( bcryptEncoder.encode( dto.getPassword() ) );
        return userRepo.save( user );
    }
}