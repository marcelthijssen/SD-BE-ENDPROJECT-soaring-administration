package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.models.Flight;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FlightService {

    List<FlightDto> getAllFlights();

    FlightDto getFlightById( Long id );

    Flight addFlight( FlightDto flightDto );

    void deleteFlightById( Long id );

    FlightDto updateFlight( Long id, FlightDto flightDto );

    void assignPlaneToFlight( Long id, Long plid );

    void assignAirportStartToFlight( Long id, Long asid );

    void assignAirportEndToFlight( Long id, Long aeid );

    void assignStartingMethodeToFlight( Long id, Long smid );

    void assignPassengerToFlight( Long id, Long psid );

    void assignCaptainToFlight( Long id, Long cpid );

//    void assignAlltoflight ( Long flid, Long plid, Long smid, Long cpid, Long psid, Long asid, Long aeid );
//    startTimer

//    stopTimer
}
