/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
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

    @GetMapping("/{plane_id}")
    public ResponseEntity<Object> getPlaneById( @PathVariable(name = "plane_id") Long plane_id ) {
        PlaneDto plane = planeService.getPlaneById( plane_id );
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

    @DeleteMapping("/{plane_id}")
    public ResponseEntity<String> deletePlaneById( @PathVariable("plane_id") Long plane_id ) {

        planeService.deletePlaneById( plane_id );
        return new ResponseEntity<>( "Plane deleted from system", HttpStatus.ACCEPTED );
    }

    @PutMapping("/{plane_id}")
    public PlaneDto updatePlane( @PathVariable("plane_id") Long plane_id, @RequestBody PlaneDto plane ) {

        return planeService.updatePlane( plane_id, plane );
    }

    //         assign owner to plane
    @PutMapping("/{plane_id}/price")
    public PlaneDto addMinutePrice( @PathVariable("plane_id") Long plane_id, @RequestBody PlaneDto plane ) {

        return planeService.addMinutePrice( plane_id, plane );
    }

    //         assign owner to plane
    @PutMapping("/{plane_id}/owner/{person_id}")
    public ResponseEntity<Object> assignOwnerToPlane( @PathVariable("plane_id") Long plane_id, @PathVariable("person_id") Long person_id ) {
        planeService.assignOwnerToPlane( plane_id, person_id );
        return new ResponseEntity<>( "Owner added to plane", HttpStatus.ACCEPTED );
    }


    //         assign technician to plane
    @PutMapping("/{plane_id}/technician/{person_id}")
    public ResponseEntity<Object> assignTechnicianToPlane( @PathVariable("plane_id") Long plane_id, @PathVariable("person_id") Long person_id ) {
        planeService.assignTechnicianToPlane( plane_id, person_id );
        return new ResponseEntity<>( "Technician added to plane", HttpStatus.ACCEPTED );
    }

    // need to upload file for plane
    @PutMapping("/flightstatus/{plane_id}")
    public String uploadFlightStatusPdf( @Valid @PathVariable("plane_id") Long plane_id, @RequestBody MultipartFile pdf ) throws IOException {
        planeService.uploadFlightStatusPdf( plane_id, pdf );
        return "File uploaded";
    }

    @GetMapping(value = "/{plane_id}/flightstatus", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] getFlightStatusPdfById( @PathVariable(name = "plane_id") Long plane_id ) {
        PlaneDto plane = planeService.getFlightStatusPdfById( plane_id );
        return plane.getFlightStatus();

    }
}
