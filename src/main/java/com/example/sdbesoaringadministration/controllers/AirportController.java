/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Managing the endpoint from /airports
 * GET / POST / PUT / DELETE
 *
 */

package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.AirportDto;
//import com.example.sdbesoaringadministration.exceptions.ExceptionHandler;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.AirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private AirportService airportService;

    public AirportController( AirportService service ) {
        this.airportService = service;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllAirports() {
        List<AirportDto> listAirportsDto = airportService.getAllAirports();
        return new ResponseEntity<>( listAirportsDto, HttpStatus.OK );
    }

    @GetMapping("/{airportId}")
    public ResponseEntity<Object> getAirportById( @PathVariable(name = "airportId") Long airportId ) {
        try {
            AirportDto airportDto = airportService.getAirportById( airportId );
            return ResponseEntity.ok( airportDto );
        } catch ( RecordNotFoundException e ) {
            throw new RecordNotFoundException( "Invalid airport-id: " + airportId, HttpStatus.NOT_FOUND );
        }
    }


    @PostMapping("")
    public ResponseEntity<Object> createAirport( @Valid @RequestBody AirportDto airportDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            airportService.createAirport( airportDto );
            return new ResponseEntity<>( "Airport added to list of airports", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/{airportId}")
    public ResponseEntity<Object> deleteAirportById( @PathVariable("airportId") Long airportId ) {
        try {
            airportService.deleteAirportById( airportId );
            return new ResponseEntity<>( "Airport has been deleted from the system.", HttpStatus.ACCEPTED );
        } catch ( Exception e ) {
            throw new RecordNotFoundException( "Invalid airport-id: " + airportId, HttpStatus.BAD_REQUEST );
        }
    }

    @PutMapping("/{airportId}")
    public AirportDto updateAirport( @PathVariable("airportId") Long airportId, @RequestBody AirportDto dto ) {

        return airportService.updateAirport( airportId, dto );
    }

}
