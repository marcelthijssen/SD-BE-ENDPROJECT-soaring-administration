package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/flights/{flid}")
    public ResponseEntity<Object> getFlightById( @PathVariable(name = "flid") Long flid ) {
        FlightDto flight = flightService.getFlightById( flid );
        try {
            return ResponseEntity.ok( flight );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    @GetMapping("/flights/captain/{pid}")
    public ResponseEntity<List<FlightDto>> getFlightByCaptain( @PathVariable(name = "pid") Long pid ) {
        List<FlightDto> flights = flightService.getFlightByCaptain( pid );

        return new ResponseEntity<>( flights, HttpStatus.OK );
    }

    @PostMapping("/flights")
    public FlightDto addFlight() {
        FlightDto dto = flightService.addFlight();
        return dto;
    }


//    }
    /*
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
     */

    @DeleteMapping("/flights/{flid}")
    public ResponseEntity<Object> deleteFlightById( @PathVariable("flid") Long flid ) {
        flightService.deleteFlightById( flid );
        return new ResponseEntity<>( "Flight has been deleted from the system.", HttpStatus.ACCEPTED );
    }

    @PutMapping("flights/{flid}")
    public FlightDto updateFlight( @PathVariable("flid") Long flid, @RequestBody FlightDto flight ) {
        FlightDto dto = flightService.updateFlight( flid, flight );
        return dto;
    }

    // Assign plane to flight
    @PutMapping("/flights/{flid}/plane/{plid}")
    public ResponseEntity<Object> assignPlaneToFlight( @PathVariable("flid") Long flid, @PathVariable("plid") Long plid ) {
        flightService.assignPlaneToFlight( flid, plid );
        return new ResponseEntity<>( "Plane added to flight", HttpStatus.ACCEPTED );
    }

    // assign Airport to flight
    @PutMapping("/flights/{flid}/airportstart/{asid}")
    public ResponseEntity<Object> assignAirportStartToFlight( @PathVariable("flid") Long flid, @PathVariable("asid") Long asid ) {
        flightService.assignAirportStartToFlight( flid, asid );
        return new ResponseEntity<>( "Starting Airport added to flight", HttpStatus.ACCEPTED );
    }

    // assign Airport to flight
    @PutMapping("/flights/{flid}/airportend/{aeid}")
    public ResponseEntity<Object> assignAirportEndToFlight( @PathVariable("flid") Long flid, @PathVariable("aeid") Long aeid ) {
        flightService.assignAirportEndToFlight( flid, aeid );
        return new ResponseEntity<>( "Landing airport added to flight", HttpStatus.ACCEPTED );
    }

    // assign starting method to flight
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

    //         assign starting method to flight
    @PutMapping("/flights/{flid}/captain/{cpid}")
    public ResponseEntity<Object> assigncaptainToFlight( @PathVariable("flid") Long flid, @PathVariable("cpid") Long cpid ) {
        flightService.assignCaptainToFlight( flid, cpid );
        return new ResponseEntity<>( "Captain added to flight", HttpStatus.ACCEPTED );
    }

    @PutMapping("/flights/{flid}/start")
    public ResponseEntity<Object> assignTimeStart( @PathVariable("flid") Long flid ) {
        flightService.assignTimeStart( flid );
        return new ResponseEntity<>( "Flight has started", HttpStatus.CREATED );
    }

    @PutMapping("/flights/{flid}/end")
    public ResponseEntity<Object> assignTimeEnd( @PathVariable("flid") Long flid ) {
        flightService.assignTimeEnd( flid );
        return new ResponseEntity<>( "Flight has ended", HttpStatus.OK );
    }


    @PutMapping("/flights/{flid}/remarks")
    public FlightDto updateRemarksToFLight( @PathVariable("flid") Long flid, @RequestBody FlightDto flight ) {
        FlightDto dto = flightService.updateRemarksToFLight( flid, flight );
        return dto;
    }
}
