package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.models.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FlightService {

    List<FlightDto> getAllFlights();

    FlightDto getFlightById( Long flid );

    Flight addFlight( FlightDto flightDto );

    void deleteFlightById( Long flid );

    FlightDto updateFlight( Long flid, FlightDto flightDto );

    void assignPlaneToFlight( Long flid, Long plid );

    void assignAirportStartToFlight( Long flid, Long asid );

    void assignAirportEndToFlight( Long flid, Long aeid );

    void assignStartingMethodeToFlight( Long flid, Long smid );

    void assignPassengerToFlight( Long flid, Long psid );

    void assignCaptainToFlight( Long flid, Long cpid );

    void assignTimeStart( Long flid);

    void assignTimeEnd( Long flid );

    List<FlightDto> getFlightByCaptain( Long pid );

//    void assignAlltoflight ( Long flid, Long plid, Long smid, Long cpid, Long psid, Long asid, Long aeid );
//    startTimer

//    stopTimer
}
