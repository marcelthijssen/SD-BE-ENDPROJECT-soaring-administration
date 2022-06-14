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
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/{flight_id}")
    public ResponseEntity<Object> getFlightById( @PathVariable(name = "flight_id") Long flight_id ) {
        FlightDto flight = flightService.getFlightById( flight_id );
        try {
            return ResponseEntity.ok( flight );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found", HttpStatus.NOT_FOUND );
        }
    }

    @GetMapping("/captain/{captain_id}")
    public ResponseEntity<List<FlightDto>> getFlightsByCaptain_id( @PathVariable(name = "captain_id") Long captain_id ) {
        List<FlightDto> flights = flightService.getFlightsByCaptain_id( captain_id );

        return new ResponseEntity<>( flights, HttpStatus.OK );
    }

    @PostMapping("")
    public Flight createFlight( FlightDto dto) {
        return flightService.createFlight(dto);
    }


    @DeleteMapping("/{flight_id}")
    public ResponseEntity<Object> deleteFlightById( @PathVariable("flight_id") Long flight_id ) {
        flightService.deleteFlightById( flight_id );
        return new ResponseEntity<>( "Flight has been deleted from the system.", HttpStatus.ACCEPTED );
    }

    @PutMapping("flights/{flight_id}")
    public FlightDto updateFlight( @PathVariable("flight_id") Long flight_id, @RequestBody FlightDto flight ) {
        return flightService.updateFlight( flight_id, flight );
    }

    @PutMapping("/{flight_id}/plane/{plane_id}")
    public ResponseEntity<Object> assignPlaneToFlight( @PathVariable("flight_id") Long flight_id, @PathVariable("plane_id") Long plane_id ) {
        flightService.assignPlaneToFlight( flight_id, plane_id );
        return new ResponseEntity<>( "Plane added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flight_id}/airportstart/{airportStart_id}")
    public ResponseEntity<Object> assignAirportStartToFlight( @PathVariable("flight_id") Long flight_id, @PathVariable("airportStart_id") Long airportStart_id ) {
        flightService.assignAirportStartToFlight( flight_id, airportStart_id );
        return new ResponseEntity<>( "Starting Airport added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flight_id}/airportend/{airportEnd_id}")
    public ResponseEntity<Object> assignAirportEndToFlight( @PathVariable("flight_id") Long flight_id, @PathVariable("airportEnd_id") Long airportEnd_id ) {
        flightService.assignAirportEndToFlight( flight_id, airportEnd_id );
        return new ResponseEntity<>( "Landing airport added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flight_id}/startingmethodes/{startingMethode_id}")
    public ResponseEntity<Object> assignStartingMethodeToFlight( @PathVariable("flight_id") Long flight_id, @PathVariable("startingMethode_id") Long startingMethode_id ) {
        flightService.assignStartingMethodeToFlight( flight_id, startingMethode_id );
        return new ResponseEntity<>( "Startingmethode added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flight_id}/passenger/{psid}")
    public ResponseEntity<String> assignPassengerToFlight( @PathVariable("flight_id") Long flight_id, @PathVariable("psid") Long psid ) {
        flightService.assignPassengerToFlight( flight_id, psid );
        return new ResponseEntity<>( "Passenger added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{flight_id}/captain/{captain_id}")
    public ResponseEntity<Object> assignCaptainToFlight( @PathVariable("flight_id") Long flight_id, @PathVariable("captain_id") Long captain_id ) {
        flightService.assignCaptainToFlight( flight_id, captain_id );
        return new ResponseEntity<>( "Captain added to flight", HttpStatus.ACCEPTED );
    }


    @PutMapping("/{flight_id}/flighttype/")
    public FlightDto assignInstructionFlightToFlight( @PathVariable("flight_id") Long flight_id, @RequestBody FlightDto flight ) {
        return flightService.assignInstructionFlightToFlight( flight_id, flight );
    }

    @PutMapping("/{flight_id}/start")
    public ResponseEntity<Object> assignTimeStart( @PathVariable("flight_id") Long flight_id ) {
        flightService.assignTimeStart( flight_id );
        return new ResponseEntity<>( "Flight has started", HttpStatus.CREATED );
    }

    @PutMapping("/{flight_id}/end")
    public ResponseEntity<Object> assignTimeEnd( @PathVariable("flight_id") Long flight_id ) {
        flightService.assignTimeEnd( flight_id );
        return new ResponseEntity<>( "Flight has ended", HttpStatus.OK );
    }

    @PutMapping("/{flight_id}/remarks")
    public FlightDto updateRemarksToFLight( @PathVariable("flight_id") Long flight_id, @RequestBody FlightDto flight ) {
        return flightService.updateRemarksToFLight( flight_id, flight );
    }

    @PutMapping("/invoice/{flight_id}")
    public ResponseEntity<String> createInvoiceFromFLight( @PathVariable("flight_id") Long flight_id ) {
        flightService.createInvoiceFromFLight( flight_id );
        return new ResponseEntity<>( "invoice created", HttpStatus.CREATED );
    }

}
