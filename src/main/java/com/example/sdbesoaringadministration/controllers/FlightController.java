package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.FlightDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
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

    @GetMapping("/{flid}")
    public ResponseEntity<Object> getFlightById( @PathVariable(name = "flid") Long flid ) {
        FlightDto flight = flightService.getFlightById( flid );
        try {
            return ResponseEntity.ok( flight );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    @GetMapping("/captain/{cpid}")
    public ResponseEntity<List<FlightDto>> getFlightsByCaptain_id( @PathVariable(name = "cpid") Long cpid ) {
        List<FlightDto> flights = flightService.getFlightsByCaptain_id( cpid );

        return new ResponseEntity<>( flights, HttpStatus.OK );
    }

    @PostMapping("")
    public FlightDto addFlight() {
        FlightDto dto = flightService.createFlight();
        return dto;
    }


//    }
    /*
      @PostMapping("")
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

    @DeleteMapping("/{flid}")
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
    @PutMapping("/{flid}/plane/{plid}")
    public ResponseEntity<Object> assignPlaneToFlight( @PathVariable("flid") Long flid, @PathVariable("plid") Long plid ) {
        flightService.assignPlaneToFlight( flid, plid );
        return new ResponseEntity<>( "Plane added to flight", HttpStatus.ACCEPTED );
    }

    // assign Airport to flight
    @PutMapping("/{flid}/airportstart/{asid}")
    public ResponseEntity<Object> assignAirportStartToFlight( @PathVariable("flid") Long flid, @PathVariable("asid") Long asid ) {
        flightService.assignAirportStartToFlight( flid, asid );
        return new ResponseEntity<>( "Starting Airport added to flight", HttpStatus.ACCEPTED );
    }

    // assign Airport to flight
    @PutMapping("/{flid}/airportend/{aeid}")
    public ResponseEntity<Object> assignAirportEndToFlight( @PathVariable("flid") Long flid, @PathVariable("aeid") Long aeid ) {
        flightService.assignAirportEndToFlight( flid, aeid );
        return new ResponseEntity<>( "Landing airport added to flight", HttpStatus.ACCEPTED );
    }

    // assign starting method to flight
    @PutMapping("/{flid}/startingmethodes/{smid}")
    public ResponseEntity<Object> assignStartingMethodeToFlight( @PathVariable("flid") Long flid, @PathVariable("smid") Long smid ) {
        flightService.assignStartingMethodeToFlight( flid, smid );
        return new ResponseEntity<>( "Startingmethode added to flight", HttpStatus.ACCEPTED );
    }

    //     assign starting method to flight
    @PutMapping("/{flid}/passenger/{psid}")
    public ResponseEntity<Object> assignPassengerToFlight( @PathVariable("flid") Long flid, @PathVariable("psid") Long psid ) {
        flightService.assignPassengerToFlight( flid, psid );
        return new ResponseEntity<>( "Passenger added to flight", HttpStatus.ACCEPTED );
    }

    //         assign starting method to flight
    @PutMapping("/{flid}/captain/{cpid}")
    public ResponseEntity<Object> assignCaptainToFlight( @PathVariable("flid") Long flid, @PathVariable("cpid") Long cpid ) {
        flightService.assignCaptainToFlight( flid, cpid );
        return new ResponseEntity<>( "Captain added to flight", HttpStatus.ACCEPTED );
    }


    @PutMapping("/{flid}/instructionflight")
    public FlightDto assignInstructionFlightToFlight( @PathVariable("flid") Long flid, @RequestBody FlightDto flight ) {
        FlightDto dto = flightService.assignInstructionFlightToFlight( flid, flight );
        return dto;
    }

    @PutMapping("/{flid}/start")
    public ResponseEntity<Object> assignTimeStart( @PathVariable("flid") Long flid ) {
        flightService.assignTimeStart( flid );
        return new ResponseEntity<>( "Flight has started", HttpStatus.CREATED );
    }

    @PutMapping("/{flid}/end")
    public ResponseEntity<Object> assignTimeEnd( @PathVariable("flid") Long flid ) {
        flightService.assignTimeEnd( flid );
        return new ResponseEntity<>( "Flight has ended", HttpStatus.OK );
    }


    @PutMapping("/{flid}/remarks")
    public FlightDto updateRemarksToFLight( @PathVariable("flid") Long flid, @RequestBody FlightDto flight ) {
        FlightDto dto = flightService.updateRemarksToFLight( flid, flight );
        return dto;
    }

    @PutMapping("/{flid}/invoice")
    public ResponseEntity<Object> createInvoicefromFLight( @PathVariable("flid") Long flid ) {
        flightService.createInvoicefromFLight( flid );
        return new ResponseEntity<>( "invoice created", HttpStatus.CREATED );
    }


}
