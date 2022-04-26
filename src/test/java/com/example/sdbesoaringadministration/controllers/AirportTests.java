package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Airport;
import com.example.sdbesoaringadministration.repositories.AirportRepository;
import com.example.sdbesoaringadministration.services.AirportServiceImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class AirportTests {

    @Mock
    AirportRepository airportRepository;

    @Mock
    AirportServiceImpl airportService;

    @Captor
    ArgumentCaptor<Airport> airportCaptor;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getAirportTest() {
        Airport airport = new Airport();
        airport.setIcao( "EHGR" );
        airport.setId( 1L );
        when( airportRepository.findById( 1L ) ).thenReturn( Optional.of( airport ) );

        airportService.getAirportById( 1L );
    }

    @Test
    public void getAirportExceptionTest() {
        Airport airport = new Airport();
        airport.setIcao( "EHGR" );
        airport.setId( 1L );
        assertThrows( RecordNotFoundException.class, () -> airportService.getAirportById( 2L ) );
    }

//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void flightControllerGetAllFlightsTest() throws JSONException {
//
//        String response = this.restTemplate.getForObject( "/airports", String.class );
//
//        JSONAssert.assertEquals( "[{id:1001},{id:1002},{id:1003},{id:1004},{id:1005},{id:1006},{id:1007},{id:1008},{id:1009},{id:1010},{id:1011}]",
//                response, false );
//    }

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


        airportService.getAllAirports();

        verify( airportService, times( 1 ) ).getAllAirports();

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
/*
    @Test
    public void updateEmployeeTest() {
        AirportDto airportDto1 = new AirportDto();
        airportDto1.setId( 1L );
        airportDto1.setIcao( "ABCD" );
        when( airportRepository.findById( 1L ) ).thenReturn( Optional.of( airportDto1 ) );

        airportDto1.setIcao( "ABCD" );
        airportService.updateAirport( 1L, airportDto1 );

        verify( airportRepository ).save( airportDto1 );

        assertThat( airportDto1.getId() ).isEqualTo( 1 );
        assertThat( airportDto1.getIcao() ).isEqualTo( "test1" );
    }
*/
    @Test
    public void updateAirportExceptionTest() {
        assertThrows( RecordNotFoundException.class, () -> airportService.getAirportById( null ) );
    }

    @Test
    public void deleteAirportTest() {
        Airport airport = new Airport();
        airport.setId( 1L );
        airport.setIcao( "ABCD" );

        airportRepository.delete( airport );

        verify( airportRepository, times( 1 ) ).delete( airport );
    }

}