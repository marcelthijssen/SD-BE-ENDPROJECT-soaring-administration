package com.example.sdbesoaringadministration.services;


import com.example.sdbesoaringadministration.dtos.UserDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.exceptions.UsernameNotFoundException;
import com.example.sdbesoaringadministration.models.Authority;
import com.example.sdbesoaringadministration.models.User;
import com.example.sdbesoaringadministration.utils.RandomStringGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {


    public List<UserDto> getUsers();
    public UserDto getUser( String username );

    public boolean userExists( String username );
    public String createUser( User user );
    public void deleteUser( String username );
    public void updateUser( String username, UserDto newUser );
    public Set<Authority> getAuthorities( String username );
    public void addAuthority( String username, String authority );
    public void removeAuthority( String username, String authority );


    }