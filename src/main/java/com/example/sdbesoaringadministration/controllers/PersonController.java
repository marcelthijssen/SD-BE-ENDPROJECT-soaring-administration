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
    public ResponseEntity<Object> getAllPersons() {
        List<PersonDto> personDtoList = personService.getAllPersons();

        return new ResponseEntity<>( personDtoList, HttpStatus.OK );
    }

    @GetMapping("/persons/{pid}")
    public ResponseEntity<Object> getPersonById( @PathVariable(name = "pid") Long pid ) {
        PersonDto person = personService.getPersonById( pid );
        try {
            return ResponseEntity.ok( person );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found" );
        }
    }

    @PostMapping("/persons")
    public ResponseEntity<Object> addPerson( @Valid @RequestBody PersonDto personDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            personService.addPerson( personDto );
            return new ResponseEntity<>( "Person added to systeem", HttpStatus.CREATED );
        }
    }


    @DeleteMapping("/persons/{pid}")
    public ResponseEntity<Object> deletePersonById( @PathVariable("pid") Long pid ) {
        personService.deletePersonById( pid );
        return new ResponseEntity<>( "Person deleted from systeem", HttpStatus.ACCEPTED );
    }

    @PutMapping("/persons/{pid}")
    public PersonDto updatePerson( @PathVariable("pid") Long pid, @RequestBody PersonDto person ) {
        PersonDto dto = personService.updatePerson( pid, person );
        return dto;
    }

    @PutMapping("/persons/{pid}/membership/{mbid}")
    public ResponseEntity<Object> addMembershipToPerson( @PathVariable("pid") Long pid, @PathVariable("mbid") Long mbid ) {
        personService.addMembershipToPerson( pid, mbid );

        return new ResponseEntity<>( "Membership added to a person", HttpStatus.OK );
    }


    @PutMapping("/persons/{pid}/role/{rid}")
    public ResponseEntity<Object> addRoleToPerson( @PathVariable("pid") Long pid, @PathVariable("rid") Long rid ) {
        personService.addMembershipToPerson( pid, rid );

        return new ResponseEntity<>( "Role added to a person", HttpStatus.OK );
    }


}
