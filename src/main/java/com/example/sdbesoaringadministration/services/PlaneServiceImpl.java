package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Plane;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import com.example.sdbesoaringadministration.repositories.PlaneRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.sdbesoaringadministration.dtos.PlaneDto.planeDtoToPlane;

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
            PlaneDto dto = new PlaneDto().planeToPlaneDto( pl );

            planeDtoList.add( dto );
        }
        return planeDtoList;
    }

    @Override
    public PlaneDto getPlaneById( Long plid ) {
        if ( plRepository.findById( plid ).isPresent() ) {
            Plane pl = plRepository.findById( plid ).get();
            return new PlaneDto().planeToPlaneDto( pl );
        } else {
            throw new RecordNotFoundException();
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
            throw new RecordNotFoundException( "Plane not found" );
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
        if ( plRepository.findById( plid ).isPresent()){
            Plane pl = plRepository.findById( plid ).get();
//            pl.setMinutePrice( plane.getMinutePrice() );
            plRepository.save(pl);
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
            throw new RecordNotFoundException( "person or plane does not exist" );
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
            throw new RecordNotFoundException( "person or plane does not exist" );
        }
    }

    @Override
    public PlaneDto AddPlaneFlightStatusPdf( Long plid, MultipartFile pdf ) throws IOException {
        if ( plRepository.findById( plid ).isPresent() ) {
            Plane pl = plRepository.findById( plid ).get();

            pl.setFlightStatus( pdf.getBytes() );

            plRepository.save( pl );
        } else {
            throw new RecordNotFoundException( "Plane not here" );
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
            throw new RecordNotFoundException();
        }
    }
}