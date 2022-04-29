package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FlightService {

    List<FlightDto> getAllFlights();

    FlightDto getFlightById( Long flid );

    FlightDto createFlight();
    void deleteFlightById( Long flid );

    FlightDto updateFlight( Long flid, FlightDto flightDto );

    void assignPlaneToFlight( Long flid, Long plid );

    void assignAirportStartToFlight( Long flid, Long asid );

    void assignAirportEndToFlight( Long flid, Long aeid );

    void assignStartingMethodeToFlight( Long flid, Long smid );

    void assignPassengerToFlight( Long flid, Long psid );

    void assignCaptainToFlight( Long flid, Long cpid );

    FlightDto assignInstructionFlightToFlight(Long flid, FlightDto dto );

        void assignTimeStart( Long flid );

    void assignTimeEnd( Long flid );

    FlightDto updateRemarksToFLight( Long flid, FlightDto dto );

    List<FlightDto> getFlightsByCaptain_id( Long cpid );

    public ResponseEntity<Object> createInvoiceFromFLight( Long flid);

}
