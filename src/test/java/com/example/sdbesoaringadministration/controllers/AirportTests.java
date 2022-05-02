/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.models.Airport;
import com.example.sdbesoaringadministration.repositories.AirportRepository;
import com.example.sdbesoaringadministration.services.AirportServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AirportTests {

    @Mock
    AirportRepository airportRepository;

    @Mock
    AirportServiceImpl service;

    @Captor
    ArgumentCaptor<Airport> airportCaptor;


    @Test
    public void returns_AirportWhen_getAirportByIdTest() {
        Airport airport = new Airport();
        airport.setIcao( "EHGR" );
        airport.setId( 1L );
        Mockito.when( airportRepository.findById( 1L ) ).thenReturn( Optional.of( airport ) );

        assertThat( airportRepository.findById( 1L ) ).isEqualTo( Optional.of( airport ) );

    }


    @Test
    public void getAirport2Test() {

        List<Airport> testAirport = new ArrayList<>();
        Airport airport1 = new Airport();
        airport1.setId( 1L );
        airport1.setIcao( "ABCD" );
        Airport airport2 = new Airport();
        airport2.setId( 2L );
        airport2.setIcao( "EFGH" );
        Airport airport3 = new Airport();
        airport3.setId( 3L );
        airport3.setIcao( "IJKL" );

        testAirport.add( airport1 );
        testAirport.add( airport2 );
        testAirport.add( airport3 );

        service.getAllAirports();

        verify( service, times( 1 ) ).getAllAirports();

        assertThat( testAirport.size() ).isEqualTo( 3 );
        assertThat( testAirport.get( 0 ) ).isEqualTo( airport1 );
        assertThat( testAirport.get( 1 ) ).isEqualTo( airport2 );
        assertThat( testAirport.get( 2 ) ).isEqualTo( airport3 );
    }

    @Test
    public void saveAirportTest() {
        Airport airport = new Airport();
        airport.setId( 1L );
        airport.setIcao( "ABCD" );

        airportRepository.save( airport );

        verify( airportRepository, times( 1 ) ).save( airportCaptor.capture() );
        var airport1 = airportCaptor.getValue();

        assertThat( airport1.getIcao() ).isEqualTo( "ABCD" );
        assertThat( airport1.getId() ).isEqualTo( 1 );
    }

}