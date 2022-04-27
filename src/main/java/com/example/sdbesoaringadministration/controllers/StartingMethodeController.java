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

    private final StartingMethodeService smService;

    public StartingMethodeController( StartingMethodeService smService ) {
        this.smService = smService;
    }


    @GetMapping("")
    public ResponseEntity<Object> getAllStartingMethode() {
        List<StartingMethodeDto> listStartingMethodeDto = smService.getAllStartingMethodes();
        return new ResponseEntity<>( listStartingMethodeDto, HttpStatus.OK );
    }

    @GetMapping("/{smid}")
    public ResponseEntity<Object> getStartingMethodeById( @PathVariable(name = "smid") Long smid ) {
        StartingMethodeDto startingMethodeDto = smService.getStartingMethodeById( smid );
        try {
            return ResponseEntity.ok( startingMethodeDto );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Startingmethode not found", HttpStatus.NOT_FOUND );
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
            smService.createStartingMethode( startingMethodeDto );
            return new ResponseEntity( "Startingmethode added to list of startingmethodes", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/{smid}")
    public ResponseEntity<Object> deleteAirportById( @PathVariable("smid") Long smid ) {

        smService.deleteStartingMethodeById( smid );
        return new ResponseEntity<>( "StartingMethode has been deleted", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{smid}")
    public StartingMethodeDto updateStartingMethode( @PathVariable("smid") Long smid, @RequestBody StartingMethodeDto dto ) {

        smService.updateStartingMethode( smid, dto );
        return dto;
    }

}
