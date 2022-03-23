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
            dto.setPrice( tom.getPrice() );
            tomDtoList.add( dto );
        }
        return tomDtoList;
    }

    @Override
    public TypeOfMembershipDto getTypeOfMembershipById( Long id ) {
        return null;
    }

    @Override
    public TypeOfMembership addTypeOfMembership( TypeOfMembershipDto typeOfMembershipDto ) {
        return null;
    }

    @Override
    public void deleteTypeOfMembershipById( Long id ) {
        if ( tomRepository.findById( id ).isPresent() ) {
            tomRepository.deleteById( id );
        } else {
            throw new RecordNotFoundException( "Plane not found" );
        }
    }


    @Override
    public TypeOfMembershipDto updateTypeOfMembership( Long id, TypeOfMembershipDto dto ) {
        return null;
    }
}
