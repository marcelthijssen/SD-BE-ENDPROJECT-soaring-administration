/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.models.User;
import com.example.sdbesoaringadministration.repositories.UserRepository;
import com.example.sdbesoaringadministration.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class UserTests {

    @Mock
    UserRepository userRepository;

    @Mock
    UserServiceImpl service;

    @Captor
    ArgumentCaptor<User> userCaptor;


    @Test
    public void returns_UserName_When_getUserByIdTest() {
        User user = new User();
        user.setEmail( "test@mail.nl" );
        user.setUsername( "testname");
        Mockito.when( userRepository.findById( "testname" ) ).thenReturn( Optional.of( user ) );

        assertThat(userRepository.findById("testname")).isEqualTo(Optional.of( user ));

    }


    @Test
    public void getUser2Test() {

        List<User> testUser = new ArrayList<>();
        User user1 = new User();
        user1.setUsername( "1L" );
        user1.setEmail( "ABCD@mail.nl" );
        User user2 = new User();
        user1.setUsername( "22L" );
        user1.setEmail( "ABCDe@mail.nl" );
        User user3 = new User();
        user1.setUsername( "3L" );
        user1.setEmail( "ABCDf@mail.nl" );

        testUser.add( user1 );
        testUser.add( user2 );
        testUser.add( user3 );


        service.getAllUsers();

        verify( service, times( 1 ) ).getAllUsers();

        assertThat( testUser.size() ).isEqualTo( 3 );
        assertThat( testUser.get( 0 ) ).isEqualTo( user1 );
        assertThat( testUser.get( 1 ) ).isEqualTo( user2 );
        assertThat( testUser.get( 2 ) ).isEqualTo( user3 );
    }

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setUsername( "1L" );
        user.setEmail( "ABCD@mail.nl" );

        userRepository.save( user );

        verify( userRepository, times( 1 ) ).save( userCaptor.capture() );
        var user1 = userCaptor.getValue();

        assertThat( user1.getUsername() ).isEqualTo( "1L" );
        assertThat( user1.getEmail() ).isEqualTo( "ABCD@mail.nl" );
    }


    @Test
    public void deleteUserTest() {
        User user = new User();
        user.setUsername( "1L" );
        user.setEmail( "ABCD@mail.nl" );

        userRepository.delete( user );

        verify( userRepository, times( 1 ) ).delete( user );
    }

}