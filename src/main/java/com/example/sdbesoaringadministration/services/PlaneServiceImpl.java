package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Plane;
import com.example.sdbesoaringadministration.repositories.PersonRepository;
import com.example.sdbesoaringadministration.repositories.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {


    private final PlaneRepository  plRepository;
    private final PersonRepository personRepository;

    public PlaneServiceImpl( PlaneRepository  plRepository, PersonRepository personRepository ) {
        this. plRepository =  plRepository;
        this.personRepository = personRepository;
    }


    @Override
    public List<PlaneDto> getAllPlanes() {
        List<Plane> planeList = this. plRepository.findAll();
        List<PlaneDto> planeDtoList = new ArrayList<>();

        for ( Plane pl : planeList ) {
            PlaneDto dto = new PlaneDto();

            dto.setId( pl.getId() );
            dto.setBrand( pl.getBrand() );
            dto.setType( pl.getType() );
            dto.isTwoSeater( pl.isTwoSeater() );
            dto.setRegistration( pl.getRegistration() );
            dto.setCallSign( pl.getCallSign() );
            dto.setPrivatePlane( pl.isPrivatePlane() );
            dto.setOwner( pl.getOwner(  ) );
            dto.setTechnician(pl.getTechnician());
            planeDtoList.add( dto );
        }
        return planeDtoList;
    }

    @Override
    public PlaneDto getPlaneById( Long plid ) {
        PlaneDto dto = new PlaneDto();
        if (  plRepository.findById( plid ).isPresent() ) {
            Plane pl =  plRepository.findById( plid ).get();
            dto.setId( pl.getId() );
            dto.setBrand( pl.getBrand() );
            dto.setType( pl.getType() );
            dto.setTwoSeater( pl.isTwoSeater() );
            dto.setRegistration( pl.getRegistration() );
            dto.setCallSign( pl.getCallSign() );
            dto.setPrivatePlane( pl.isPrivatePlane() );
            dto.setOwner( pl.getOwner() );
            dto.setTechnician(pl.getTechnician());
            return dto;
        } else {
            throw new RecordNotFoundException( "No such plane here" );
        }
    }

    @Override
    public Plane addPlane( PlaneDto planeDto ) {
        Plane pl = new Plane();
        pl.setId( planeDto.getId() );
        pl.setBrand( planeDto.getBrand() );
        pl.setType( planeDto.getType() );
        pl.setTwoSeater( planeDto.isTwoSeater( pl.isTwoSeater() ) );
        pl.setRegistration( planeDto.getRegistration() );
        pl.setCallSign( planeDto.getCallSign() );
        pl.setPrivatePlane( planeDto.isPrivatePlane() );
        pl.setOwner( planeDto.getOwner() );
        pl.setTechnician( planeDto.getTechnician() );
        return this. plRepository.save( pl );
    }

    @Override
    public void deletePlaneById( Long plid ) {
        if (  plRepository.findById( plid ).isPresent() ) {
             plRepository.deleteById( plid );
        } else {
            throw new RecordNotFoundException( "Plane not found" );
        }
    }

    @Override
    public PlaneDto updatePlane( Long id, PlaneDto dto ) {
        return null;
    }



    @Override
    public void assignOwnerToPlane( Long plid, Long pid ) {
        var optionalPlane =  plRepository.findById( plid );
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
        var optionalPlane =  plRepository.findById( plid );
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

}
