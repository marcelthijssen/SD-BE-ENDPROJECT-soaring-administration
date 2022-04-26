package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Person;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import com.example.sdbesoaringadministration.services.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;





    @ExtendWith(MockitoExtension.class)
    public class PersonTests {

        @Mock
        PersonRepository repo;

        @Mock
        PersonServiceImpl personService;

        @Captor
        ArgumentCaptor<Person> personCaptor;

        @Autowired
        private MockMvc mockMvc;


        @Test
        public void getPersonTest() {
            Person person = new Person();
            person.setFirstName( "jan" );
            person.setId( 1L );
            when( repo.findById( 1L ) ).thenReturn( Optional.of( person ) );

            personService.getPersonById( 1L );
        }

        @Test
        public void getPersonExceptionTest() {
            Person person = new Person();
//            person.setFirstName( "jan" );
            person.setId( 1L );
            assertThrows( RecordNotFoundException.class, () -> personService.getPersonById( 2L ) );
        }

//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void flightControllerGetAllFlightsTest() throws JSONException {
//
//        String response = this.restTemplate.getForObject( "/persons", String.class );
//
//        JSONAssert.assertEquals( "[{id:1001},{id:1002},{id:1003},{id:1004},{id:1005},{id:1006},{id:1007},{id:1008},{id:1009},{id:1010},{id:1011}]",
//                response, false );
//    }

        @Test
        public void getPerson2Test() {

            List<Person> testPerson = new ArrayList<>();
            Person person1 = new Person();
            person1.setId( 1L );
            person1.setFirstName( "ABCD" );
            Person person2 = new Person();
            person2.setId( 2L );
            person2.setFirstName( "EFGH" );
            Person person3 = new Person();
            person3.setId( 3L );
            person3.setFirstName( "IJKL" );

            testPerson.add( person1 );
            testPerson.add( person2 );
            testPerson.add( person3 );


            personService.getAllPersons();

            verify( personService, times( 1 ) ).getAllPersons();

            assertThat( testPerson.size() ).isEqualTo( 3 );
            assertThat( testPerson.get( 0 ) ).isEqualTo( person1 );
            assertThat( testPerson.get( 1 ) ).isEqualTo( person2 );
            assertThat( testPerson.get( 2 ) ).isEqualTo( person3 );
        }

        @Test
        public void savePersonTest() {
            Person person = new Person();
            person.setId( 1L );
            person.setFirstName( "ABCD" );

            repo.save( person );

            verify( repo, times( 1 ) ).save( personCaptor.capture() );
            var person1 = personCaptor.getValue();

            assertThat( person1.getFirstName() ).isEqualTo( "ABCD" );
            assertThat( person1.getId() ).isEqualTo( 1 );
        }
        /*
            @Test
            public void updateEmployeeTest() {
                PersonDto personDto1 = new PersonDto();
                personDto1.setId( 1L );
                personDto1.setFirstName( "ABCD" );
                when( repo.findById( 1L ) ).thenReturn( Optional.of( personDto1 ) );
        
                personDto1.setFirstName( "ABCD" );
                personService.updatePerson( 1L, personDto1 );
        
                verify( repo ).save( personDto1 );
        
                assertThat( personDto1.getId() ).isEqualTo( 1 );
                assertThat( personDto1.getIcao() ).isEqualTo( "test1" );
            }
        */
        @Test
        public void updatePersonExceptionTest() {
             assertThrows( RecordNotFoundException.class, () -> personService.getPersonById(  null ) );
        }

        @Test
        public void deletePersonTest() {
            Person person = new Person();
            person.setId( 1L );
            person.setFirstName( "ABCD" );

            repo.delete( person );

            verify( repo, times( 1 ) ).delete( person );
        }

    }