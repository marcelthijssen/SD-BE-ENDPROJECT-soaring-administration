package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.TypeOfMembershipDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.TypeOfMembershipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TypeOfMembershipController {


    private final TypeOfMembershipService tomService;

    public TypeOfMembershipController( TypeOfMembershipService tomService ) {
        this.tomService = tomService;
    }


    @GetMapping("/toms")
    public ResponseEntity<Object> getAllTypeOfMemberships() {
        List<TypeOfMembershipDto> listTypeOfMembershipDto = tomService.getAllTypeOfMemberships();
        return new ResponseEntity<>( listTypeOfMembershipDto, HttpStatus.OK );
    }

    @GetMapping("/toms/{id}")
    public ResponseEntity<Object> getTypeOfMembershipById( @PathVariable(name = "id") Long id ) {
        TypeOfMembershipDto typeOfMembershipDto = tomService.getTypeOfMembershipById(id );
        try {
            return ResponseEntity.ok( typeOfMembershipDto );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Type of Membership not found" );
        }
    }


    @PostMapping("/toms")
    public ResponseEntity<Object> addTypeOfMembership(@Valid @RequestBody TypeOfMembershipDto typeOfMembershipDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            tomService.addTypeOfMembership( typeOfMembershipDto );
            return new ResponseEntity( "Type of Membership added", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/toms/{id}")
    public void deleteTypeOfMembershipById(@PathVariable("id") Long id) {

        tomService.deleteTypeOfMembershipById(id);

    }


    @PutMapping("/toms/{id}")

    public TypeOfMembershipDto updateTypeOfMembership(@PathVariable("id") Long id, @RequestBody TypeOfMembershipDto dto) {

        TypeOfMembershipDto typeOfMembershipDto = tomService.updateTypeOfMembership(id, dto);

        return typeOfMembershipDto;

    }


}
