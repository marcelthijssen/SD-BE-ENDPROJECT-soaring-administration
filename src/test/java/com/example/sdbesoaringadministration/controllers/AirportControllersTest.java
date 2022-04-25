//package com.example.sdbesoaringadministration.controllers;
//
//import com.example.sdbesoaringadministration.models.Airport;
//import com.example.sdbesoaringadministration.services.AirportService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.hamcrest.Matchers.hasSize;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class AirportControllersTest {
//        @Autowired
//        private MockMvc mvc;
//
//        @MockBean
//        private AirportService airportService;
//
//        @Test
//        public void testEndpointCustomers() throws Exception {
//
//        Airport airport = new Airport();
//        airport.setIcao( "EHGR" );
//        airport.setCity( "Gilze-Rijen");
//        airport.setCountry( "Netherlands" );
//        List<Airport> allAirports = List.of( airport );
//
//            given(airportService.getAllAirports()).willReturn( allAirports );
//
//            mvc.perform(get("/airports")
//                            .contentType( MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("$", hasSize(1)))
//                    .andExpect(jsonPath("$[0].icao", is(airport.getIcao())));
//        }
//
//    }



//    @Autowired
//    private MockMvc mvc;
//
//
//    @MockBean
//    private AirportService airportService;
//
//    @Test
//    public void testEndpointAirport() throws Exception {
//
//        Airport airport = new Airport();
//        airport.setIcao( "EHGR" );
//        airport.setCity( "Gilze-Rijen");
//        airport.setCountry( "Netherlands" );
//
//        List<Airport> airports = Arrays.asList( airport );
//        airports.add( airport );
//        given( airportService.getAllAirports() ).equals( airports );
//
//        mvc.perform( get( "/airports" )
//                        .contentType( MediaType.APPLICATION_JSON ) )
//                .andExpect( status().isOk() )
//                .andExpect( jsonPath( "$", hasSize( 1 ) ) )
//                .andExpect( jsonPath( "$[0].icao", is( airport.getIcao() ) ) );
//    }
//
//}
