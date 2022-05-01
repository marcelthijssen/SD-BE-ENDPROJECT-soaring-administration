package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.models.Person;
import com.example.sdbesoaringadministration.repositories.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class FlightServiceImplTest {



    @Mock
    private FlightServiceImpl service;
    @Mock
    private FlightRepository repository;
    @Captor
    ArgumentCaptor<Flight> personCaptor;

    @Test
    void ShouldReturnAllFlights() {
        List<FlightDto> flList = new ArrayList<>();
        FlightDto fl1 = new FlightDto();
        flList.add( fl1 );
        FlightDto fl2 = new FlightDto();
        flList.add( fl2 );
        FlightDto fl3 = new FlightDto();
        flList.add( fl3 );
        service.getAllFlights(  );

        verify( service, times( 1 ) ).getAllFlights();

        assertThat( flList.size() ).isEqualTo( 3 );

    }

    @Test
    void ShouldReturnOneFlight_getFlightById() {
        List<FlightDto> flList = new ArrayList<>();
        FlightDto fl1 = new FlightDto();
        flList.add( fl1 );
        FlightDto fl2 = new FlightDto();
        flList.add( fl2 );
        FlightDto fl3 = new FlightDto();
        flList.add( fl3 );

        service.getFlightById(2L);

        verify( service, times( 1 ) ).getFlightById(2L);

        assertThat( flList.size() ).isEqualTo( 3 );
        assertThat( flList.get( 1 ) ).isEqualTo( fl2 );
    }

    @Test
    void createFlight() {
    }

    @Test
    void shouldDeleteAFlightById() {
        List<FlightDto> flList = new ArrayList<>();
        FlightDto fl1 = new FlightDto();
        flList.add( fl1 );
        FlightDto fl2 = new FlightDto();
        flList.add( fl2 );
        FlightDto fl3 = new FlightDto();
        flList.add( fl3 );

        service.deleteFlightById(0L);

        verify( service, times( 1 ) ).deleteFlightById(0L);

        assertThat( flList.size() ).isEqualTo( 2 );
    }

}
/*
    @Test
    public void deletePersonTest() {
        Person person = new Person();
        person.setId( 1L );
        person.setFirstName( "ABCD" );

        repo.delete( person );

        verify( repo, times( 1 ) ).delete( person );
    }
 */