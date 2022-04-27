package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.UserDto;
import com.example.sdbesoaringadministration.exceptions.BadRequestException;
import com.example.sdbesoaringadministration.exceptions.UsernameNotFoundException;
import com.example.sdbesoaringadministration.models.User;
import com.example.sdbesoaringadministration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public ResponseEntity<List<UserDto>> getUsers() {

        List<UserDto> userDtoList = userService.getUsers();

        return ResponseEntity.ok().body( userDtoList );
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<UserDto> getUser( @PathVariable("username") String username ) {
        try {
            UserDto optionalUser = userService.getUser( username );

            return ResponseEntity.ok().body( optionalUser );
        } catch (UsernameNotFoundException ex) {
            throw new UsernameNotFoundException(HttpStatus.NOT_FOUND, username );
        }
    }

    @PostMapping(value = "")
    public ResponseEntity<String> createUser( @RequestBody User user ) {

        String newUsername = userService.createUser( user );

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path( "/{username}" )
                .buildAndExpand( newUsername ).toUri();

        return new ResponseEntity( "New user added " + user.getUsername(), HttpStatus.CREATED );
    }

    @PutMapping(value = "/{username}")
    public ResponseEntity<UserDto> updateUser( @PathVariable("username") String username, @RequestBody UserDto dto ) {

        userService.updateUser( username, dto );

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{username}")
    public ResponseEntity<Object> deleteUser( @PathVariable("username") String username ) {
        userService.deleteUser( username );
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> getUserAuthorities( @PathVariable("username") String username ) {
        return ResponseEntity.ok().body( userService.getAuthorities( username ) );
    }

    @PostMapping(value = "/{username}/authorities")
    public ResponseEntity<Object> addUserAuthority( @PathVariable("username") String username, @RequestBody Map<String, Object> fields ) {
        try {
            String authorityName = ( String ) fields.get( "authority" );
            userService.addAuthority( username, authorityName );
            return ResponseEntity.noContent().build();
        } catch ( Exception ex ) {
            throw new BadRequestException();
        }
    }

    @DeleteMapping(value = "/{username}/authorities/{authority}")
    public ResponseEntity<Object> deleteUserAuthority( @PathVariable("username") String username, @PathVariable("authority") String authority ) {
        userService.removeAuthority( username, authority );
        return ResponseEntity.noContent().build();
    }

}