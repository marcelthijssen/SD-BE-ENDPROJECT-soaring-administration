/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Controller of endpoint from '/planes'
 *
 * GET / POST / PUT / DELETE
 * and assings a owner and a technician to a specific plane
 *
 */

package com.example.sdbesoaringadministration.controllers;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.services.PlaneService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    private final PlaneService planeService;

    public PlaneController( PlaneService planeService ) {
        this.planeService = planeService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllPlanes() {
        List<PlaneDto> planeDtoList = planeService.getAllPlanes();

        return new ResponseEntity<>( planeDtoList, HttpStatus.OK );
    }

    @GetMapping("/{planeId}")
    public ResponseEntity<Object> getPlaneById( @PathVariable(name = "planeId") Long planeId ) {
        PlaneDto plane = planeService.getPlaneById( planeId );
        try {
            return ResponseEntity.ok( plane );
        } catch ( Exception ex ) {
            throw new RecordNotFoundException( "Plane Not found", HttpStatus.NOT_FOUND );
        }
    }

    @PostMapping("")
    public ResponseEntity<Object> createPlane( @Valid @RequestBody PlaneDto planeDto, BindingResult br ) {
        if ( br.hasErrors() ) {
            StringBuilder sb = new StringBuilder();
            for ( FieldError fe : br.getFieldErrors() ) {
                sb.append( fe.getDefaultMessage() );
                sb.append( "\n" );
            }
            return new ResponseEntity<>( sb.toString(), HttpStatus.BAD_REQUEST );
        } else {
            planeService.createPlane( planeDto );
            return new ResponseEntity<>( "plane added to systeem", HttpStatus.CREATED );
        }
    }

    @DeleteMapping("/{planeId}")
    public ResponseEntity<String> deletePlaneById( @PathVariable("planeId") Long planeId ) {

        planeService.deletePlaneById( planeId );
        return new ResponseEntity<>( "Plane deleted from system", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{planeId}")
    public PlaneDto updatePlane( @PathVariable("planeId") Long planeId, @RequestBody PlaneDto plane ) {

        return planeService.updatePlane( planeId, plane );
    }

    //         assign owner to plane
    @PutMapping("/{planeId}/price")
    public PlaneDto addMinutePrice( @PathVariable("planeId") Long planeId, @RequestBody PlaneDto plane ) {

        return planeService.addMinutePrice( planeId, plane );
    }

    //         assign owner to plane
    @PutMapping("/{planeId}/owner/{personId}")
    public ResponseEntity<Object> assignOwnerToPlane( @PathVariable("planeId") Long planeId, @PathVariable("personId") Long personId ) {
        planeService.assignOwnerToPlane( planeId, personId );
        return new ResponseEntity<>( "Owner added to plane", HttpStatus.ACCEPTED );
    }


    //         assign technician to plane
    @PutMapping("/{planeId}/technician/{personId}")
    public ResponseEntity<Object> assignTechnicianToPlane( @PathVariable("planeId") Long planeId, @PathVariable("personId") Long personId ) {
        planeService.assignTechnicianToPlane( planeId, personId );
        return new ResponseEntity<>( "Technician added to plane", HttpStatus.ACCEPTED );
    }

    // need to upload file for plane
    @PutMapping("/flightstatus/{planeId}")
    public String uploadFlightStatusPdf( @Valid @PathVariable("planeId") Long planeId, @RequestBody MultipartFile pdf ) throws IOException {
        planeService.uploadFlightStatusPdf( planeId, pdf );
        return "File uploaded";
    }

    @GetMapping(value = "/{planeId}/flightstatus", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] getFlightStatusPdfById( @PathVariable(name = "planeId") Long planeId ) {
        PlaneDto plane = planeService.getFlightStatusPdfById( planeId );
        return plane.getFlightStatus();

    }
}
