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
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FlightService {

    List<FlightDto> getAllFlights();

    FlightDto getFlightById( Long flightId );

    Flight createFlight( FlightDto dto);

    void deleteFlightById( Long flightId );

    FlightDto updateFlight( Long flightId, FlightDto flightDto );

    void assignPlaneToFlight( Long flightId, Long planeId );

    void assignAirportStartToFlight( Long flightId, Long airportStartId );

    void assignAirportEndToFlight( Long flightId, Long airportEndId );

    void assignStartingMethodeToFlight( Long flightId, Long startingMethodeId );

    void assignPassengerToFlight( Long flightId, Long psid );

    void assignCaptainToFlight( Long flightId, Long captainId );

    FlightDto assignInstructionFlightToFlight(Long flightId, FlightDto dto );

    void assignTimeStart( Long flightId );

    void assignTimeEnd( Long flightId );

    FlightDto updateRemarksToFLight( Long flightId, FlightDto dto );

    List<FlightDto> getFlightsByCaptain_id( Long captainId );

    public ResponseEntity<String> createInvoiceFromFLight( Long flightId);

}
