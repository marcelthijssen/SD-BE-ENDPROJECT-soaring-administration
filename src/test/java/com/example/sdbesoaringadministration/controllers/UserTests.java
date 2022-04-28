package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.User;
import com.example.sdbesoaringadministration.repositories.UserRepository;
import com.example.sdbesoaringadministration.services.UserServiceImpl;
import com.example.sdbesoaringadministration.services.UserServiceImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class UserTests {

    @Mock
    UserRepository userRepository;

    @Mock
    UserServiceImpl service;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void returns_UserName_When_getUserByIdTest() {
        User user = new User();
        user.setEmail( "test@mail.nl" );
        user.setUsername( "testname");
        Mockito.when( userRepository.findById( "testname" ) ).thenReturn( Optional.of( user ) );

        assertThat(userRepository.findById("testname")).isEqualTo(Optional.of( user ));

    }

//    @Test
//    public void gives_RecordNotFoundException_when_getUserById_fails_Test() {
//        User user = new User();
//        user.setIcao( "EHGR" );
//        user.setId( 1L );
//        return assertThrown( RecordNotFoundException.class, () -> service.getUserById( 2L ) );
//    }

//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void flightControllerGetAllFlightsTest() throws JSONException {
//
//        String response = this.restTemplate.getForObject( "/users", String.class );
//
//        JSONAssert.assertEquals( "[{id:1001},{id:1002},{id:1003},{id:1004},{id:1005},{id:1006},{id:1007},{id:1008},{id:1009},{id:1010},{id:1011}]",
//                response, false );
//    }

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
    /*
        @Test
        public void updateEmployeeTest() {
            UserDto userDto1 = new UserDto();
            userDto1.setId( 1L );
            userDto1.setIcao( "ABCD" );
            when( userRepository.findById( 1L ) ).thenReturn( Optional.of( userDto1 ) );
    
            userDto1.setIcao( "ABCD" );
            service.updateUser( 1L, userDto1 );
    
            verify( userRepository ).save( userDto1 );
    
            assertThat( userDto1.getId() ).isEqualTo( 1 );
            assertThat( userDto1.getIcao() ).isEqualTo( "test1" );
        }
    */
//    @Test
//    public void updateUserExceptionTest() {
//        assertThrows( RecordNotFoundException.class, () -> service.getUserById( null ) );
//        throw new RecordNotFoundException( "nit found" , HttpStatus.NOT_FOUND );
//    }
    @Test
    public void whenExceptionThrown_thenAssertionSucceeds() {
        Exception ex = assertThrows(RecordNotFoundException.class, () -> {
            service.getUserById( null );
        });

        String expectedMessage = "For input string";
        String actualMessage = ex.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
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