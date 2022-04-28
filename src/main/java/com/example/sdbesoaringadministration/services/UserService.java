package com.example.sdbesoaringadministration.services;


import com.example.sdbesoaringadministration.dtos.UserDto;
import com.example.sdbesoaringadministration.models.Authority;
import com.example.sdbesoaringadministration.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface UserService {


    public List<UserDto> getAllUsers();
    public UserDto getUserById( String username );
    public boolean userExists( String username );
    public String createUser( User user );
    public void deleteUser( String username );
    public ResponseEntity<Object> updateUser( String username, UserDto newUser );
    public Set<Authority> getAuthorities( String username );
    public void addAuthority( String username, String authority );
    public void removeAuthority( String username, String authority );


    }