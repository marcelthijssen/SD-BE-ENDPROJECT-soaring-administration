/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;


import com.example.sdbesoaringadministration.dtos.UserDto;
import com.example.sdbesoaringadministration.models.Authority;
import com.example.sdbesoaringadministration.models.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Set;

public interface UserService {


    List<UserDto> getAllUsers();

    UserDto getUserById( String username );

    Boolean userExists( String username );

    String createUser( User user );

    void deleteUser( String username );

    ResponseEntity<Object> updateUser( String username, UserDto newUser );

    Set<Authority> getAuthorities( String username );

    void addAuthority( String username, String authority );

    void removeAuthority( String username, String authority );


}