package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.SdBeSoaringAdministrationApplication;
import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.repositories.FlightRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
@SpringBootTest
@DataJpaTest
@ContextConfiguration(classes = {SdBeSoaringAdministrationApplication.class})
class FlightServiceImplTest {


    @Mock
    private FlightServiceImpl service;
    @Mock
    private FlightRepository repository;
    @Mock
    FlightDto flightDto;

//    @Test
//    void getAllFlights() {
//        FlightDto fl1 = new FlightDto();
//        FlightDto fl2 = new FlightDto();
//        FlightDto fl3 = new FlightDto();
////        List<FlightDto> flList = new ArrayList<>();
//        repository.save( fl1. );
//        repository.save( fl2 );
//        repository.save( fl3 );
//
//        service.getFlightById( 2L );
//
//        verify( service, times( 1 ) ).getAllFlights();
//
//        assertThat( flList.size() ).isEqualTo( 3 );
//        assertThat( flList.get( 1 ) ).isEqualTo( fl1 );
//
//    }

    @Test
    void getFlightById() {
        FlightDto fl1 = new FlightDto();
        FlightDto fl2 = new FlightDto();
        FlightDto fl3 = new FlightDto();
        List<FlightDto> flList = new ArrayList<>();
        flList.add( fl1 );
        flList.add( fl2 );
        flList.add( fl3 );

        service.getAllFlights();

        verify( service, times( 1 ) ).getAllFlights();

        assertThat( flList.size() ).isEqualTo( 3 );
        assertThat( flList.get( 0 ) ).isEqualTo( fl1 );
        assertThat( flList.get( 1 ) ).isEqualTo( fl2 );
        assertThat( flList.get( 2 ) ).isEqualTo( fl3 );
    }

    @Test
    void createFlight() {
    }

    @Test
    void deleteFlightById() {
        FlightDto fl1 = new FlightDto();
        FlightDto fl2 = new FlightDto();
        FlightDto fl3 = new FlightDto();
        List<FlightDto> flList = new ArrayList<>();
        flList.add( fl1 );
        flList.add( fl2 );
        flList.add( fl3 );

        service.deleteFlightById( 2L );

        verify( service, times( 1 ) ).getAllFlights();

        assertThat( flList.size() ).isEqualTo( 2 );

    }

}