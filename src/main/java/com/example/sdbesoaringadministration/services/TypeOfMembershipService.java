package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.TypeOfMembershipDto;

import java.util.List;

public interface TypeOfMembershipService {

    List<TypeOfMembershipDto> getAllTypeOfMemberships();

    TypeOfMembershipDto getTypeOfMembershipById( Long id );

    void addTypeOfMembership( TypeOfMembershipDto typeOfMembershipDto );

    void deleteTypeOfMembershipById( Long id );

    TypeOfMembershipDto  updateTypeOfMembership( Long id, TypeOfMembershipDto dto );
}
