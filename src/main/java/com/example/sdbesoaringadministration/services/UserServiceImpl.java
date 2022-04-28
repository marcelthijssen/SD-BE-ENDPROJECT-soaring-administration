package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.UserDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.exceptions.UsernameNotFoundException;
import com.example.sdbesoaringadministration.exceptions.UsernameAlreadyExistException;

import com.example.sdbesoaringadministration.models.Authority;
import com.example.sdbesoaringadministration.models.User;
import com.example.sdbesoaringadministration.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


//    @Autowired
//    private AuthorityRepository authorityRepository;

    public List<UserDto> getAllUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for ( User u : list ) {
            collection.add( userToUserDto( u ) );
        }
        return collection;
    }

    public UserDto getUserById( String username ) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById( username );
        if ( user.isPresent() ) {
            dto = userToUserDto( user.get() );
        } else {
            throw new UsernameNotFoundException( HttpStatus.NOT_FOUND, username );
        }
        return dto;
    }

    public boolean userExists( String username ) {
        return userRepository.existsById( username );
    }

    public String createUser( User user ) {

        if ( userExists( user.getUsername() ) ) {
            throw new UsernameAlreadyExistException( "Username allready in use, please choose another" );
        } else {
            user.setEmail( user.getEmail() );
            user.setPassword( passwordEncoder.encode( user.getPassword() ) );
            user.getAuthorities().clear();
            user.addAuthority( new Authority( user.getUsername(), "ROLE_USER" ) );
            userRepository.save( user );

            return "New user added";
        }
    }

    public void deleteUser( String username ) {
        userRepository.deleteById( username );
    }

    public ResponseEntity<Object> updateUser( String username, UserDto newUser ) {
            if ( !userRepository.existsById( username ) )
                throw new RecordNotFoundException( "Not found", HttpStatus.NOT_FOUND );
            User user = userRepository.findById( username ).get();
            user.setPassword( newUser.getPassword() );
            userRepository.save( user );

            return new ResponseEntity<>( HttpStatus.OK );
    }

    public Set<Authority> getAuthorities( String username ) {
        if ( !userRepository.existsById( username ) ) throw new UsernameNotFoundException( HttpStatus.NOT_FOUND, username );
        User user = userRepository.findById( username ).get();
        UserDto dto = userToUserDto( user );
        return dto.getAuthorities();
    }

    public void addAuthority( String username, String authority ) {

        if ( !userRepository.existsById( username ) ) throw new UsernameNotFoundException( HttpStatus.NOT_FOUND, username );
        User user = userRepository.findById( username ).get();
        user.addAuthority( new Authority( username, authority ) );
        userRepository.save( user );
    }

    public void removeAuthority( String username, String authority ) {
        if ( !userRepository.existsById( username ) ) throw new UsernameNotFoundException( HttpStatus.NOT_FOUND, username );
        User user = userRepository.findById( username ).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter( ( a ) -> a.getAuthority().equalsIgnoreCase( authority ) ).findAny().get();
        user.removeAuthority( authorityToRemove );
        userRepository.save( user );
    }

    public static UserDto userToUserDto( User user ) {

        UserDto dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.enabled = user.getEnabled();
        dto.email = user.getEmail();
        dto.authorities = user.getAuthorities();

        return dto;
    }

    public User dtoToUser( UserDto dto ) {

        User u = new User();

        u.setUsername( dto.getUsername() );
        u.setPassword( dto.getPassword() );
        u.setEnabled( dto.getEnabled() );
        u.setEmail( dto.getEmail() );

        return u;

    }

}