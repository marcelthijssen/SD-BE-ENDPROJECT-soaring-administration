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
public class StartingMethodeController {

    private final StartingMethodeService smService;

    public StartingMethodeController( StartingMethodeService smService ) {
        this.smService = smService;
    }


    @GetMapping("/startingmethodes")
    public ResponseEntity<Object> getAllStartingMethode() {
        List<StartingMethodeDto> listStartingMethodeDto = smService.getAllStartingMethodes();
        return new ResponseEntity<>( listStartingMethodeDto, HttpStatus.OK );
    }

    @GetMapping("/startingmethodes/{id}")
    public ResponseEntity<Object> getStartingMethodeById( @PathVariable(name = "id") Long id ) {
        StartingMethodeDto startingMethodeDto = smService.getStartingMethodeById(  id );
        try {
            return ResponseEntity.ok( startingMethodeDto );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "artingmethode not found" );
        }
    }


    @PostMapping("/startingmethodes")
    public ResponseEntity<Object> addAStartingMethode( @Valid @RequestBody StartingMethodeDto startingMethodeDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            smService.addStartingMethode( startingMethodeDto );
            return new ResponseEntity( "Startingmethode added to list of startingmethodes", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/startingmethodes/{id}")
    public void deleteAirportById(@PathVariable("id") Long id) {

        smService.deleteStartingMethodeById( id);

    }

    @PutMapping("/startingmethodes/{id}")
    public StartingMethodeDto updateStartingMethode(@PathVariable("id") Long id, @RequestBody StartingMethodeDto dto) {

        smService.updateStartingMethode(id, dto);
        return dto;
    }

}
