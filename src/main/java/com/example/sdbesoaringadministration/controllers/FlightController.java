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
    @GetMapping("/Flights/{id}")
    public ResponseEntity<Object> getFlightById( @PathVariable(name = "id") Long id ) {
        FlightDto tv = flightService.getFlightById( id );
        try {
            return ResponseEntity.ok( tv );
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
            return new ResponseEntity( "Televisie aangemaakt", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/flights/{id}")
    public void deleteFlightById( @PathVariable("id") Long id ) {

        flightService.deleteFlightById( id );

    }

    @PutMapping("flights/{id}")
    public FlightDto updateFlight( @PathVariable("id") Long id, @RequestBody FlightDto flight ) {

        FlightDto dto = flightService.updateFlight( id, flight );

        return dto;

    }


}