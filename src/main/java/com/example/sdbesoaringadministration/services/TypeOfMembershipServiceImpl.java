package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.TypeOfMembershipDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.TypeOfMembership;
import com.example.sdbesoaringadministration.repositories.TypeOfMembershipRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sdbesoaringadministration.dtos.TypeOfMembershipDto.typeOfMembershipDtoToTypeOfMembership;

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
            TypeOfMembershipDto dto = new TypeOfMembershipDto().typeOfMembershipToTypeOfMembershipDto( tom );
            tomDtoList.add( dto );
        }
        return tomDtoList;
    }

    @Override
    public TypeOfMembershipDto getTypeOfMembershipById( Long tid ) {
        if ( tomRepository.findById( tid ).isPresent() ) {
            TypeOfMembership tom = tomRepository.findById( tid ).get();

            return new TypeOfMembershipDto().typeOfMembershipToTypeOfMembershipDto( tom );
        } else {
            throw new RecordNotFoundException( "Type of Membership not found" );
        }
    }

    @Override
    public void addTypeOfMembership( TypeOfMembershipDto dto ) {
        TypeOfMembership tom = typeOfMembershipDtoToTypeOfMembership(dto);
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
            tom.setTitle( dto.getTitle() );
            tom.setCostsPerMonth( dto.getCostsPerMonth() );
            tomRepository.save( tom );
        } else {
            throw new RecordNotFoundException( "Type of membership not found" );
        }
        return null;
    }
}
