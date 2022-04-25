package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.AirportDto;
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
public class AirportController {

    private final AirportService airportService;

    public AirportController( AirportService service ) {
        this.airportService = service;
    }


    @GetMapping("/airports")
    public ResponseEntity<Object> getAllAirports() {
        List<AirportDto> listAirportsDto = airportService.getAllAirports();
        return new ResponseEntity<>( listAirportsDto, HttpStatus.OK );
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<Object> getAirportById( @PathVariable(name = "id") Long id ) {
        AirportDto airportDto = airportService.getAirportsById( id );
        try {
            return ResponseEntity.ok( airportDto );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Airport not found" );
        }
    }


    @PostMapping("/airports")
    public ResponseEntity<Object> addAirport( @Valid @RequestBody AirportDto airportDto, BindingResult br ) {
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

    @DeleteMapping("/airports/{id}")
    public ResponseEntity<Object> deleteAirportById( @PathVariable("id") Long id ) {

        airportService.deleteAirportById( id );
        return new ResponseEntity<>( "Airport has been deleted from the system.", HttpStatus.ACCEPTED );
    }

    @PutMapping("/airports/{id}")
    public AirportDto updateAirport( @PathVariable("id") Long id, @RequestBody AirportDto dto ) {

        // after update we are ready so using inline variable
        return airportService.updateAirport( id, dto );
    }

}
