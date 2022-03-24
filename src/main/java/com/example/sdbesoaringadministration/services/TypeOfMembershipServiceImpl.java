package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.TypeOfMembershipDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.TypeOfMembership;
import com.example.sdbesoaringadministration.repositories.TypeOfMembershipRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeOfMembershipServiceImpl implements TypeOfMembershipService {


    private final TypeOfMembershipRepository tomRepository;

    public TypeOfMembershipServiceImpl( TypeOfMembershipRepository tomRepository ) {
        this.tomRepository = tomRepository;
    }

    @Override
    public List<TypeOfMembershipDto> getAllTypeOfMemberships() {
        List<TypeOfMembership> tomList = this.tomRepository.findAll();
        List<TypeOfMembershipDto> tomDtoList = new ArrayList<>();

        for ( TypeOfMembership tom : tomList ) {
            TypeOfMembershipDto dto = new TypeOfMembershipDto();
            dto.setId( tom.getId() );
            dto.setTitle( tom.getTitle() );
            dto.setCostsPerMonth( tom.getCostsPerMonth() );
            tomDtoList.add( dto );
        }
        return tomDtoList;
    }

    @Override
    public TypeOfMembershipDto getTypeOfMembershipById( Long id ) {
        TypeOfMembershipDto dto = new TypeOfMembershipDto();
        if ( tomRepository.findById( id ).isPresent() ) {
            TypeOfMembership tom = tomRepository.findById( id ).get();
            dto.setId( tom.getId() );
            dto.setTitle( tom.getTitle() );
            dto.setCostsPerMonth( tom.getCostsPerMonth() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Type of Membership not found" );
        }
    }

    @Override
    public void addTypeOfMembership( TypeOfMembershipDto typeOfMembershipDto ) {
        TypeOfMembership tom = new TypeOfMembership();
        tom.setId( typeOfMembershipDto.getId() );
        tom.setTitle( typeOfMembershipDto.getTitle() );
        tom.setCostsPerMonth( typeOfMembershipDto.getCostsPerMonth() );
        this.tomRepository.save( tom );
    }

    @Override
    public void deleteTypeOfMembershipById( Long id ) {
        if ( tomRepository.findById( id ).isPresent() ) {
            tomRepository.deleteById( id );
        } else {
            throw new RecordNotFoundException( "Type of Membership not found" );
        }
    }


    @Override
    public TypeOfMembershipDto updateTypeOfMembership( Long id, TypeOfMembershipDto dto ) {
        if ( tomRepository.findById( id ).isPresent() ) {
            TypeOfMembership tom = tomRepository.findById( id ).get();

            tom.setId( tom.getId() );
            tom.setTitle( tom.getTitle() );
            tom.setCostsPerMonth( tom.getCostsPerMonth() );
            tomRepository.save( tom );
        } else {
            throw new RecordNotFoundException( "Type of membership not found" );
        }
        return null;
    }
}
