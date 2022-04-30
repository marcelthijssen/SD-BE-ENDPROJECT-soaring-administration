package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Plane;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import com.example.sdbesoaringadministration.repositories.PlaneRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository plRepository;
    private final PersonRepository personRepository;

    public PlaneServiceImpl( PlaneRepository plRepository, PersonRepository personRepository ) {
        this.plRepository = plRepository;
        this.personRepository = personRepository;
    }

    @Override
    public List<PlaneDto> getAllPlanes() {
        List<Plane> planeList = this.plRepository.findAll();
        List<PlaneDto> planeDtoList = new ArrayList<>();

        for ( Plane pl : planeList ) {
            planeDtoList.add( planeToPlaneDto( pl ) );
        }
        return planeDtoList;
    }

    @Override
    public PlaneDto getPlaneById( Long plid ) {
        try {
            Plane pl = plRepository.findById( plid ).get();
            PlaneDto dto = ( planeToPlaneDto( pl ) );
            return dto;
        } catch ( Exception e ) {
            throw new RecordNotFoundException( "Invalid plane id: " + plid, HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public Plane createPlane( PlaneDto dto ) {
        Plane plane = planeDtoToPlane( dto );
        return this.plRepository.save( plane );
    }

    @Override
    public void deletePlaneById( Long plid ) {
        if ( plRepository.findById( plid ).isPresent() ) {
            plRepository.deleteById( plid );
        } else {
            throw new RecordNotFoundException( "Invalid plane id: " + plid, HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public PlaneDto updatePlane( Long plid, PlaneDto dto ) {
        if ( plRepository.findById( plid ).isPresent() ) {
            Plane pl = plRepository.findById( plid ).get();
            plRepository.save( pl );
        }
        return null;
    }

    public PlaneDto addMinutePrice( Long plid, PlaneDto dto ) {
        if ( plRepository.findById( plid ).isPresent() ) {
            Plane pl = plRepository.findById( plid ).get();
            plRepository.save( pl );
        }
        return dto;
    }

    @Override
    public void assignOwnerToPlane( Long plid, Long pid ) {
        var optionalPlane = plRepository.findById( plid );
        var optionalPerson = personRepository.findById( pid );

        if ( optionalPlane.isPresent() && optionalPerson.isPresent() ) {
            var plane = optionalPlane.get();
            var person = optionalPerson.get();

            plane.setOwner( person );
            plRepository.save( plane );
        } else {
            throw new RecordNotFoundException( "Invalid plane-id: " + plid + ", or invalid person-id: " + pid, HttpStatus.NOT_FOUND );
        }
    }


    @Override
    public void assignTechnicianToPlane( Long plid, Long pid ) {
        var optionalPlane = plRepository.findById( plid );
        var optionalPerson = personRepository.findById( pid );

        if ( optionalPlane.isPresent() && optionalPerson.isPresent() ) {
            var plane = optionalPlane.get();
            var person = optionalPerson.get();

            plane.setTechnician( person );
            plRepository.save( plane );
        } else {
            throw new RecordNotFoundException( "person or plane does not exist", HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public PlaneDto addPlaneFlightStatusPdf( Long plid, MultipartFile pdf ) throws IOException {

        try {
            if ( plRepository.findById( plid ).isPresent() ) {
                Plane pl = plRepository.findById( plid ).get();
                pl.setFlightStatus( pdf.getBytes() );
                plRepository.save( pl );
            }
        } catch ( RecordNotFoundException e ) {
            throw new RecordNotFoundException( "Invalid plane-id: " + plid, HttpStatus.NOT_FOUND );
        }
        return null;
    }


    @Override
    public PlaneDto getPlaneFlightStatusById( Long plid ) {
        if ( plRepository.findById( plid ).isPresent() ) {
            Plane pl = plRepository.findById( plid ).get();
            PlaneDto dto = new PlaneDto();

            dto.setFlightStatus( pl.getFlightStatus() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Invalid plane-id: " + plid, HttpStatus.NOT_FOUND );
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
