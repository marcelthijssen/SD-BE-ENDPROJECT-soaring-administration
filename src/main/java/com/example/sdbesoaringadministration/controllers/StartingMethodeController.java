/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Controller of endpoints from '/startingmethodes'
 * GET / POST / PUT / DELETE
 *
 */

package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.StartingMethodeDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.StartingMethodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/startingmethodes")
public class StartingMethodeController {

    private final StartingMethodeService startingMethodesService;

    public StartingMethodeController( StartingMethodeService startingMethodesService ) {
        this.startingMethodesService = startingMethodesService;
    }


    @GetMapping("")
    public ResponseEntity<Object> getAllStartingMethode() {
        List<StartingMethodeDto> listStartingMethodeDto = startingMethodesService.getAllStartingMethodes();
        return new ResponseEntity<>( listStartingMethodeDto, HttpStatus.OK );
    }

    @GetMapping("/{startingMethodeId}")
    public ResponseEntity<Object> getStartingMethodeById( @PathVariable(name = "startingMethodeId") Long startingMethodeId ) {
        StartingMethodeDto startingMethodeDto = startingMethodesService.getStartingMethodeById( startingMethodeId );
        try {
            return ResponseEntity.ok( startingMethodeDto );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Invalid Startingmethode id: "+ startingMethodeId, HttpStatus.NOT_FOUND );
        }
    }


    @PostMapping("")
    public ResponseEntity<Object> addAStartingMethode( @Valid @RequestBody StartingMethodeDto startingMethodeDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            startingMethodesService.createStartingMethode( startingMethodeDto );
            return new ResponseEntity<>( "Startingmethode added to list of startingmethodes", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/{startingMethodeId}")
    public ResponseEntity<Object> deleteAirportById( @PathVariable("startingMethodeId") Long startingMethodeId ) {

        startingMethodesService.deleteStartingMethodeById( startingMethodeId );
        return new ResponseEntity<>( "StartingMethode has been deleted", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{startingMethodeId}")
    public StartingMethodeDto updateStartingMethode( @PathVariable("startingMethodeId") Long startingMethodeId, @RequestBody StartingMethodeDto dto ) {

        startingMethodesService.updateStartingMethode( startingMethodeId, dto );
        return dto;
    }

}
