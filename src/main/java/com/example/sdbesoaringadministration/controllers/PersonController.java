/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Controller of endpoints of '/persons'
 *
 * GET / POST / PUT / DELETE
 *
 */

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
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController( PersonService personService ) {
        this.personService = personService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllPersons() {
        List<PersonDto> personDtoList = personService.getAllPersons();

        return new ResponseEntity<>( personDtoList, HttpStatus.OK );
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Object> getPersonById( @PathVariable(name = "personId") Long personId ) {
        PersonDto person = personService.getPersonById( personId );
        try {
            return ResponseEntity.ok( person );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Not found", HttpStatus.NOT_FOUND );
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> createPerson( @Valid @RequestBody PersonDto personDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            personService.createPerson( personDto );
            return new ResponseEntity<>( "Person added to systeem", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Object> deletePersonById( @PathVariable("personId") Long personId ) {
        personService.deletePersonById( personId );
        return new ResponseEntity<>( "Person deleted from systeem", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{personId}")
    public PersonDto updatePerson( @PathVariable("personId") Long personId, @RequestBody PersonDto person ) {
        return personService.updatePerson( personId, person );
    }

    @PutMapping("/{personId}/membership/{membershipId}")
    public ResponseEntity<Object> addMembershipToPerson( @PathVariable("personId") Long personId, @PathVariable("membershipId") Long membershipId ) {
        personService.addMembershipToPerson( personId, membershipId );

        return new ResponseEntity<>( "Membership added to a person", HttpStatus.OK );
    }

}
