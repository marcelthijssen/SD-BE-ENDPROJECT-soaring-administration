package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.PlaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController( PlaneService planeService ) {
        this.planeService = planeService;
    }

    @GetMapping("/planes")
    public ResponseEntity<Object> getAllPlanes(){
        List<PlaneDto> planeDtoList = planeService.getAllPlanes();

        return new ResponseEntity<>( planeDtoList, HttpStatus.OK );
    }


    @GetMapping("/planes/{id}")
    public ResponseEntity<Object> getPlaneById( @PathVariable(name = "id") Long id ) {
        PlaneDto plane = planeService.getPlaneById( id );
        try {
            return ResponseEntity.ok( plane );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Plane Not found" );
        }
    }

    //    Check if plane type is allready in db, if so do nothing and reply is already in db
    @PostMapping("/planes")
    public ResponseEntity<Object> addPlane( @Valid @RequestBody PlaneDto planeDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            planeService.addPlane( planeDto );
            return new ResponseEntity<>( "plane added to systeem", HttpStatus.CREATED );
        }
    }


    @DeleteMapping("/planes/{id}")
    public void deletePlaneById( @PathVariable("id") Long id ) {

        planeService.deletePlaneById( id );

    }

    @PutMapping("/planes/{id}")
    public PlaneDto updatePlane( @PathVariable("id") Long id, @RequestBody PlaneDto plane ) {

        PlaneDto dto = planeService.updatePlane( id, plane );

        return dto;

    }

}
