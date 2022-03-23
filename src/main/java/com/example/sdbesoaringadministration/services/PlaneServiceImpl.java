package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Plane;
import com.example.sdbesoaringadministration.repositories.PlaneRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneServiceImpl implements PlaneService {


    private final PlaneRepository planeRepository;

    public PlaneServiceImpl( PlaneRepository planeRepository ) {
        this.planeRepository = planeRepository;
    }


    @Override
    public List<PlaneDto> getAllPlanes() {
        List<Plane> planeList = this.planeRepository.findAll();
        List<PlaneDto> planeDtoList = new ArrayList<>();

        for ( Plane pl : planeList ) {
            PlaneDto dto = new PlaneDto();

            dto.setId( pl.getId() );
            dto.setBrand( pl.getBrand() );
            dto.setType( pl.getType() );
            dto.isTwoSeater( pl.isTwoSeater() );
            dto.setRegistration( pl.getRegistration() );
            dto.setCallSign( pl.getCallSign() );
            dto.isPrivatePlane( pl.isPrivatePlane() );
            planeDtoList.add( dto );

        }
        return planeDtoList;

    }

    @Override
    public PlaneDto getPlaneById( Long id ) {
        PlaneDto dto = new PlaneDto();
        if ( planeRepository.findById( id ).isPresent() ){
            Plane pl=planeRepository.findById( id ).get();
            dto.setId( pl.getId() );
            dto.setBrand( pl.getBrand() );
            dto.setType( pl.getType() );
            dto.isTwoSeater( pl.isTwoSeater() );
            dto.setRegistration( pl.getRegistration() );
            dto.setCallSign( pl.getCallSign() );
            dto.isPrivatePlane( pl.isPrivatePlane() );
            return dto;
        } else {
            throw new RecordNotFoundException("No such plane here");
        }
    }

    @Override
    public Plane addPlane( PlaneDto planeDto ) {
        Plane pl = new Plane();
        pl.setId( planeDto.getId() );
        pl.setBrand( planeDto.getBrand() );
        pl.setType( planeDto.getType() );
//        pl.setTwoSeater( planeDto.isTwoSeater() );
        pl.setRegistration( planeDto.getRegistration() );
        pl.setCallSign( planeDto.getCallSign() );
//        pl.setPrivatePlane( planeDto.isPrivatePlane() );
        return this.planeRepository.save(pl);


    }

    @Override
    public void deletePlaneById( Long id ) {
        if ( planeRepository.findById( id ).isPresent() ) {
            planeRepository.deleteById( id );
        } else {
            throw new RecordNotFoundException( "Plane not found" );
        }
    }

    @Override
    public PlaneDto updatePlane( Long id, PlaneDto dto ) {
        return null;
    }
}
