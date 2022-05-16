/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Implements methodes for PlaneController
 *
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Plane;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import com.example.sdbesoaringadministration.repositories.PlaneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository planeRepository;
    private final PersonRepository personRepository;

    public PlaneServiceImpl( PlaneRepository planeRepository, PersonRepository personRepository ) {
        this.planeRepository = planeRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<PlaneDto> getAllPlanes() {
        List<Plane> planeList = this.planeRepository.findAll();
        List<PlaneDto> planeDtoList = new ArrayList<>();

        for ( Plane pl : planeList ) {
            planeDtoList.add( planeToPlaneDto( pl ) );
        }
        return planeDtoList;
    }

    @Override
    public PlaneDto getPlaneById( Long planeId ) {
        try {
            Plane pl = planeRepository.findById( planeId ).get();
            return ( planeToPlaneDto( pl ) );
        } catch ( Exception e ) {
            throw new RecordNotFoundException( "Invalid plane id: " + planeId, HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public ResponseEntity<Object> createPlane( PlaneDto dto ) {
        Plane plane = planeDtoToPlane( dto );
         this.planeRepository.save( plane );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public void deletePlaneById( Long planeId ) {
        if ( planeRepository.findById( planeId ).isPresent() ) {
            planeRepository.deleteById( planeId );
        } else {
            throw new RecordNotFoundException( "Invalid plane id: " + planeId, HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public PlaneDto updatePlane( Long planeId, PlaneDto dto ) {
        if ( planeRepository.findById( planeId ).isPresent() ) {
            Plane pl = planeRepository.findById( planeId ).get();
            planeRepository.save( pl );
        }
        return null;
    }

    public PlaneDto addMinutePrice( Long planeId, PlaneDto dto ) {
        if ( planeRepository.findById( planeId ).isPresent() ) {
            Plane pl = planeRepository.findById( planeId ).get();
            planeRepository.save( pl );
        }
        return dto;
    }

    @Override
    public void assignOwnerToPlane( Long planeId, Long personId ) {
        var optionalPlane = planeRepository.findById( planeId );
        var optionalPerson = personRepository.findById( personId );

        if ( optionalPlane.isPresent() && optionalPerson.isPresent() ) {
            var plane = optionalPlane.get();
            var person = optionalPerson.get();

            plane.setOwner( person );
            planeRepository.save( plane );
        } else {
            throw new RecordNotFoundException( "Invalid plane-id: " + planeId + ", or invalid person-id: " + personId, HttpStatus.NOT_FOUND );
        }
    }


    @Override
    public void assignTechnicianToPlane( Long planeId, Long personId ) {
        var optionalPlane = planeRepository.findById( planeId );
        var optionalPerson = personRepository.findById( personId );

        if ( optionalPlane.isPresent() && optionalPerson.isPresent() ) {
            var plane = optionalPlane.get();
            var person = optionalPerson.get();

            plane.setTechnician( person );
            planeRepository.save( plane );
        } else {
            throw new RecordNotFoundException( "person or plane does not exist", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public void uploadFlightStatusPdf( Long planeId, MultipartFile pdf ) throws IOException {

        try {
            if ( planeRepository.findById( planeId ).isPresent() ) {
                Plane pl = planeRepository.findById( planeId ).get();
                pl.setFlightStatus( pdf.getBytes() );
                planeRepository.save( pl );
            }
        } catch ( RecordNotFoundException e ) {
            throw new RecordNotFoundException( "Invalid plane-id: " + planeId, HttpStatus.NOT_FOUND );
        }
    }


    @Override
    public PlaneDto getFlightStatusPdfById( Long planeId ) {
        if ( planeRepository.findById( planeId ).isPresent() ) {
            Plane pl = planeRepository.findById( planeId ).get();
            PlaneDto dto = new PlaneDto();

            dto.setFlightStatus( pl.getFlightStatus() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Invalid plane-id: " + planeId, HttpStatus.NOT_FOUND );
        }
    }

    public static PlaneDto planeToPlaneDto( Plane pl ) {
        PlaneDto dto = new PlaneDto();

            dto.setId( pl.getId() );
            dto.setCallSign( pl.getCallSign() );
            dto.setBrand( pl.getBrand() );
            dto.setType( pl.getType() );
            dto.setRegistration( pl.getRegistration() );
            dto.setTwoSeater( pl.getTwoSeater() );
            dto.setPrivatePlane( pl.getPrivatePlane() );
            dto.setOwner( pl.getOwner() );
            dto.setTechnician( pl.getTechnician() );
            dto.setFlightStatus( pl.getFlightStatus() );
            return dto;

    }

    public static Plane planeDtoToPlane( PlaneDto dto ) {
        Plane pl = new Plane();

        pl.setId( dto.getId() );
        pl.setCallSign( dto.getCallSign() );
        pl.setBrand( dto.getBrand() );
        pl.setType( dto.getType() );
        pl.setRegistration( dto.getRegistration() );
        pl.setTwoSeater( dto.getTwoSeater() );
        pl.setPrivatePlane( dto.getPrivatePlane() );
        pl.setOwner( dto.getOwner() );
        pl.setTechnician( dto.getTechnician() );
        pl.setFlightStatus( dto.getFlightStatus() );
        return pl;

    }
}
