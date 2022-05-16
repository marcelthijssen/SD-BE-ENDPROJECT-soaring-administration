/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Controller of the endpoints for '/flights
 * GET / POST / PUT / DELETE
 * Creates flights and assigns: captain, passenger, airportStart, airportEnd, timeStart, timeEnd, startingMethode, instructionFlight, addRemarks and createInvoiceFromFlight
 *
 */

package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Flight;
import com.example.sdbesoaringadministration.services.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController( FlightService flightService ) {
        this.flightService = flightService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllFlights() {
        List<FlightDto> lt = flightService.getAllFlights();

        return new ResponseEntity<>( lt, HttpStatus.OK );
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Object> getFlightById( @PathVariable(name = "flightId") Long flightId ) {
        FlightDto flight = flightService.getFlightById( flightId );
        try {
            return ResponseEntity.ok( flight );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found", HttpStatus.NOT_FOUND );
        }
    }

    @GetMapping("/captain/{captainId}")
    public ResponseEntity<List<FlightDto>> getFlightsByCaptain_id( @PathVariable(name = "captainId") Long captainId ) {
        List<FlightDto> flights = flightService.getFlightsByCaptain_id( captainId );

        return new ResponseEntity<>( flights, HttpStatus.OK );
    }

    @PostMapping("")
    public Flight createFlight( FlightDto dto) {
        return flightService.createFlight(dto);
    }


    @DeleteMapping("/{flightId}")
    public ResponseEntity<Object> deleteFlightById( @PathVariable("flightId") Long flightId ) {
        flightService.deleteFlightById( flightId );
        return new ResponseEntity<>( "Flight has been deleted from the system.", HttpStatus.ACCEPTED );
    }

    @PutMapping("flights/{flightId}")
    public FlightDto updateFlight( @PathVariable("flightId") Long flightId, @RequestBody FlightDto flight ) {
        return flightService.updateFlight( flightId, flight );
    }

    @PutMapping("/{flightId}/plane/{planeId}")
    public ResponseEntity<Object> assignPlaneToFlight( @PathVariable("flightId") Long flightId, @PathVariable("planeId") Long planeId ) {
        flightService.assignPlaneToFlight( flightId, planeId );
        return new ResponseEntity<>( "Plane added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flightId}/airportstart/{airportStartId}")
    public ResponseEntity<Object> assignAirportStartToFlight( @PathVariable("flightId") Long flightId, @PathVariable("airportStartId") Long airportStartId ) {
        flightService.assignAirportStartToFlight( flightId, airportStartId );
        return new ResponseEntity<>( "Starting Airport added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flightId}/airportend/{airportEndId}")
    public ResponseEntity<Object> assignAirportEndToFlight( @PathVariable("flightId") Long flightId, @PathVariable("airportEndId") Long airportEndId ) {
        flightService.assignAirportEndToFlight( flightId, airportEndId );
        return new ResponseEntity<>( "Landing airport added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flightId}/startingmethodes/{startingMethodeId}")
    public ResponseEntity<Object> assignStartingMethodeToFlight( @PathVariable("flightId") Long flightId, @PathVariable("startingMethodeId") Long startingMethodeId ) {
        flightService.assignStartingMethodeToFlight( flightId, startingMethodeId );
        return new ResponseEntity<>( "Startingmethode added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flightId}/passenger/{psid}")
    public ResponseEntity<String> assignPassengerToFlight( @PathVariable("flightId") Long flightId, @PathVariable("psid") Long psid ) {
        flightService.assignPassengerToFlight( flightId, psid );
        return new ResponseEntity<>( "Passenger added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flightId}/captain/{captainId}")
    public ResponseEntity<Object> assignCaptainToFlight( @PathVariable("flightId") Long flightId, @PathVariable("captainId") Long captainId ) {
        flightService.assignCaptainToFlight( flightId, captainId );
        return new ResponseEntity<>( "Captain added to flight", HttpStatus.ACCEPTED );
    }


    @PutMapping("/{flightId}/instructionflight")
    public FlightDto assignInstructionFlightToFlight( @PathVariable("flightId") Long flightId, @RequestBody FlightDto flight ) {
        return flightService.assignInstructionFlightToFlight( flightId, flight );
    }

    @PutMapping("/{flightId}/start")
    public ResponseEntity<Object> assignTimeStart( @PathVariable("flightId") Long flightId ) {
        flightService.assignTimeStart( flightId );
        return new ResponseEntity<>( "Flight has started", HttpStatus.CREATED );
    }

    @PutMapping("/{flightId}/end")
    public ResponseEntity<Object> assignTimeEnd( @PathVariable("flightId") Long flightId ) {
        flightService.assignTimeEnd( flightId );
        return new ResponseEntity<>( "Flight has ended", HttpStatus.OK );
    }

    @PutMapping("/{flightId}/remarks")
    public FlightDto updateRemarksToFLight( @PathVariable("flightId") Long flightId, @RequestBody FlightDto flight ) {
        return flightService.updateRemarksToFLight( flightId, flight );
    }

    @PutMapping("/invoice/{flightId}")
    public ResponseEntity<String> createInvoiceFromFLight( @PathVariable("flightId") Long flightId ) {
        flightService.createInvoiceFromFLight( flightId );
        return new ResponseEntity<>( "invoice created", HttpStatus.CREATED );
    }

}
