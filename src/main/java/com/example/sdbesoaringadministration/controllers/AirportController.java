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

    private final AirportService service;

    public AirportController( AirportService service ) {
        this.service = service;
    }


    @GetMapping("/airports")
    public ResponseEntity<Object> getAllAirports() {
        List<AirportDto> listAirportsDto = service.getAllAirports();
        return new ResponseEntity<>( listAirportsDto, HttpStatus.OK );
    }

    @GetMapping("/airports/{id}")
    public ResponseEntity<Object> getAirportById( @PathVariable(name = "id") Long id ) {
        AirportDto airportDto = service.getAirportsById( id );
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
            service.addAirport( airportDto );
            return new ResponseEntity( "CI-Module is aangemaakt", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/airports/{id}")
    public void deleteCiModuleById(@PathVariable("id") Long id) {

        service.deleteAirportById(id);

    }

    @PutMapping("/airports/{id}")
    public AirportDto updateCiModule(@PathVariable("id") Long id, @RequestBody AirportDto ciModule) {

        AirportDto airportDto = service.updateAirport(id, ciModule);

        return airportDto;

    }

}
