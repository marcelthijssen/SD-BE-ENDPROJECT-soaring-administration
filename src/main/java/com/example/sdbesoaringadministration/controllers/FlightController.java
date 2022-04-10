package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FlightController {

    private final FlightService flightService;

    public FlightController( FlightService flightService ) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public ResponseEntity<Object> getAllFlights() {
        List<FlightDto> lt = flightService.getAllFlights();

        return new ResponseEntity<>( lt, HttpStatus.OK );
    }

    // changed <FlightDto> to <Object>
    @GetMapping("/flights/{id}")
    public ResponseEntity<Object> getFlightById( @PathVariable(name = "id") Long id ) {
        FlightDto flight = flightService.getFlightById( id );
        try {
            return ResponseEntity.ok( flight );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    //    Check if flight type is allready in db, if so do nothing and reply is already in db
    @PostMapping("/flights")
    public ResponseEntity<Object> addFlight( @Valid @RequestBody FlightDto flightDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            flightService.addFlight( flightDto );
            return new ResponseEntity<>( "Flight has been added", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/flights/{id}")
    public ResponseEntity<Object> deleteFlightById( @PathVariable("id") Long id ) {

        flightService.deleteFlightById( id );
        return new ResponseEntity<>( "Flight has been deleted from the system.", HttpStatus.ACCEPTED );

    }

    @PutMapping("flights/{id}")
    public FlightDto updateFlight( @PathVariable("id") Long id, @RequestBody FlightDto flight ) {

        FlightDto dto = flightService.updateFlight( id, flight );

        return dto;

    }

    // Assign plane to flight
    @PutMapping("/flights/{flid}/plane/{plid}")
    public ResponseEntity<Object> assignPlaneToFlight( @PathVariable("flid") Long flid, @PathVariable("plid") Long plid ) {
        flightService.assignPlaneToFlight( flid, plid );
        return new ResponseEntity<>( "Plane added to flight", HttpStatus.ACCEPTED );
    }

    // assign Airport to flight
    @PutMapping("/flights/{flid}/plane/{apid}")
    public ResponseEntity<Object> assignAirportToFlight( @PathVariable("flid") Long flid, @PathVariable("apid") Long apid ) {
        flightService.assignAirportToFlight( flid, apid );
        return new ResponseEntity<>( "Plane added to flight", HttpStatus.ACCEPTED );
    }

    //     assign starting method to flight
    @PutMapping("/flights/{flid}/startingmethodes/{smid}")
    public ResponseEntity<Object> assignStartingMethodeToFlight( @PathVariable("flid") Long flid, @PathVariable("smid") Long smid ) {
        flightService.assignStartingMethodeToFlight( flid, smid );
        return new ResponseEntity<>( "Startingmethode added to flight", HttpStatus.ACCEPTED );
    }

    //     assign starting method to flight
    @PutMapping("/flights/{flid}/passenger/{psid}")
    public ResponseEntity<Object> assignPassengerToFlight( @PathVariable("flid") Long flid, @PathVariable("psid") Long psid ) {
        flightService.assignPassengerToFlight( flid, psid );
        return new ResponseEntity<>( "Passenger added to flight", HttpStatus.ACCEPTED );
    }

    //     assign starting method to flight
//    @PutMapping("/flights/{flid}/captain/{cpid}")
//    public ResponseEntity<Object> assigncaptainToFlight( @PathVariable("flid") Long flid, @PathVariable("cpid") Long cpid ) {
//        flightService.assignCaptainToFlight( flid, cpid );
//        return new ResponseEntity<>( "Captain added to flight", HttpStatus.ACCEPTED );
//    }
}