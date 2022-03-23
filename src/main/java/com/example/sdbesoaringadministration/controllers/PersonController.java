package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.PersonDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController( PersonService personService ) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public ResponseEntity<Object> getAllPersons(){
        List<PersonDto> personDtoList = personService.getAllPersons();

        return new ResponseEntity<>( personDtoList, HttpStatus.OK );
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Object> getPersonById( @PathVariable(name = "id") Long id ) {
        PersonDto tv = personService.getPersonById( id );
        try {
            return ResponseEntity.ok( tv );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    //    Check if person type is allready in db, if so do nothing and reply is already in db
    @PostMapping("/persons")
    public ResponseEntity<Object> addTelevision( @Valid @RequestBody PersonDto personDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            personService.addPerson( personDto );
            return new ResponseEntity( "Person added to systeem", HttpStatus.CREATED );
        }
    }


    @DeleteMapping("/persons/{id}")
    public void deletePersonById( @PathVariable("id") Long id ) {

        personService.deletePersonById( id );

    }

    @PutMapping("/persons/{id}")
    public PersonDto updateTelevision( @PathVariable("id") Long id, @RequestBody PersonDto person ) {

        PersonDto dto = personService.updatePerson( id, person );

        return dto;

    }

}
