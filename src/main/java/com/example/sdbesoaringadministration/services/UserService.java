package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.UserDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.exceptions.UsernameNotFoundException;
import com.example.sdbesoaringadministration.models.Authority;
import com.example.sdbesoaringadministration.models.User;
import com.example.sdbesoaringadministration.repositories.UserRepository;
import com.example.sdbesoaringadministration.utils.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


//    @Autowired
//    private AuthorityRepository authorityRepository;

    public List<UserDto> getUsers() {
        List<UserDto> collection = new ArrayList<>();
        List<User> list = userRepository.findAll();
        for ( User u : list ) {
            collection.add( userToUserDto( u ) );
        }
        return collection;
    }

    public UserDto getUser( String username ) {
        UserDto dto = new UserDto();
        Optional<User> user = userRepository.findById( username );
        if ( user.isPresent() ) {
            dto = userToUserDto( user.get() );
        } else {
            throw new UsernameNotFoundException( username );
        }
        return dto;
    }

    public boolean userExists( String username ) {
        return userRepository.existsById( username );
    }

    public String createUser( final UserDto dto ) {
        String randomString = RandomStringGenerator.generateAlphaNumeric( 20 );
        User newUser = userRepository.save( userDtoToUser( dto ) );
        return newUser.getUsername();
    }

    public void deleteUser( String username ) {
        userRepository.deleteById( username );
    }

    public void updateUser( String username, UserDto newUser ) {
        if ( !userRepository.existsById( username ) ) throw new RecordNotFoundException();
        User user = userRepository.findById( username ).get();
        user.setPassword( newUser.getPassword() );
        userRepository.save( user );
    }

    public Set<Authority> getAuthorities( String username ) {
        if ( !userRepository.existsById( username ) ) throw new UsernameNotFoundException( username );
        User user = userRepository.findById( username ).get();
        UserDto userDto = userToUserDto( user );
        return userDto.getAuthorities();
    }

    public void addAuthority( String username, String authority ) {

        if ( !userRepository.existsById( username ) ) throw new UsernameNotFoundException( username );
        User user = userRepository.findById( username ).get();
        user.addAuthority( new Authority( username, authority ) );
        userRepository.save( user );
    }

    public void removeAuthority( String username, String authority ) {
        if ( !userRepository.existsById( username ) ) throw new UsernameNotFoundException( username );
        User user = userRepository.findById( username ).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter( ( a ) -> a.getAuthority().equalsIgnoreCase( authority ) ).findAny().get();
        user.removeAuthority( authorityToRemove );
        userRepository.save( user );
    }

    public static UserDto userToUserDto( User user ) {

        UserDto dto = new UserDto();

        dto.username = user.getUsername();
        dto.password = user.getPassword();
        dto.enabled = user.isEnabled();
        dto.apikey = user.getApikey();
        dto.email = user.getEmail();
        dto.authorities = user.getAuthorities();

        return dto;
    }

    public User userDtoToUser( UserDto dto ) {

        User u = new User();

        u.setUsername( dto.getUsername() );
        u.setPassword( dto.getPassword() );
        u.setEnabled( dto.getEnabled() );
        u.setApikey( dto.getApikey() );
        u.setEmail( dto.getEmail() );

        return u;
    }

}