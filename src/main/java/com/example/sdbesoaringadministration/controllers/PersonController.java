/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Controller of endpoints of '/persons'
 *
 * GET / POST / PUT / DELETE
 *
 */

package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.AddressDto;
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

@CrossOrigin
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

    @GetMapping("/{person_id}")
    public ResponseEntity<Object> getPersonById( @PathVariable(name = "person_id") Long person_id ) {
        PersonDto person = personService.getPersonById( person_id );
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
//            Create addressRepo for this person
//            addressService.createAddres();
            return new ResponseEntity<>( "Person added to systeem", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/{person_id}")
    public ResponseEntity<Object> deletePersonById( @PathVariable(name = "person_id") Long person_id ) {
        personService.deletePersonById( person_id );
        return new ResponseEntity<>( "Person deleted from systeem", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{person_id}")
    public PersonDto updatePerson( @PathVariable("person_id") Long person_id, @RequestBody PersonDto person ) {
        return personService.updatePerson( person_id, person );
    }

    @PutMapping("/{person_id}/membership/{membership_id}")
    public ResponseEntity<Object> addMembershipToPerson( @PathVariable(name = "person_id") Long person_id, @PathVariable("membership_id") Long membership_id ) {
        personService.addMembershipToPerson( person_id, membership_id );

        return new ResponseEntity<>( "Membership added to a person", HttpStatus.OK );
    }

    @PutMapping("/{person_id}/address")
    public ResponseEntity<Object> addAddressToPerson( @PathVariable(name = "person_id") Long person_id, @Valid @RequestBody AddressDto addressDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            personService.addAddressToPerson( person_id, addressDto );
//            Create addressRepo for this person
//            addressService.createAddres()
            return new ResponseEntity<>( "Address added to Person", HttpStatus.CREATED );
        }
    }
}


