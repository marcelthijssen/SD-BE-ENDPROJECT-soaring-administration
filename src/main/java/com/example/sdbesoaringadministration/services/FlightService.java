/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.models.Flight;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FlightService {

    List<FlightDto> getAllFlights();

    FlightDto getFlightById( Long flight_id );

    Flight createFlight( FlightDto dto);

    void deleteFlightById( Long flight_id );

    FlightDto updateFlight( Long flight_id, FlightDto flightDto );

    void assignPlaneToFlight( Long flight_id, Long plane_id );

    void assignAirportStartToFlight( Long flight_id, Long airportStart_id );

    void assignAirportEndToFlight( Long flight_id, Long airportEnd_id );

    void assignStartingMethodeToFlight( Long flight_id, Long startingMethode_id );

    void assignPassengerToFlight( Long flight_id, Long psid );

    void assignCaptainToFlight( Long flight_id, Long captain_id );

    FlightDto assignInstructionFlightToFlight(Long flight_id, FlightDto dto );

    void assignTimeStart( Long flight_id );

    void assignTimeEnd( Long flight_id );

    FlightDto updateRemarksToFLight( Long flight_id, FlightDto dto );

    List<FlightDto> getFlightsByCaptain_id( Long captain_id );

    public ResponseEntity<String> createInvoiceFromFLight( Long flight_id);

}
