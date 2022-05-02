/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.repositories.FlightRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    private FlightRepository flRepository;

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
    void shouldDeleteById() {
        List<Flight> flList = new ArrayList<>();
        Flight fl1 = new Flight();
        fl1.setId( 0L );
        flRepository.save( fl1 );
        Flight fl2 = new Flight();
        fl1.setId( 1L );
        flRepository.save( fl2 );
        Flight fl3 = new Flight();
        fl1.setId( 2L );
        flRepository.save( fl3 );
        flList = flRepository.findAll();

        flRepository.deleteById( 0L );

        verify( flRepository, times( 1 ) ).deleteById(0L);

        assertThat( flList.size() ).isEqualTo( 2 );
    }

}
