package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.PlaneDto;
import com.example.sdbesoaringadministration.dtos.TypeOfMembershipDto;
import com.example.sdbesoaringadministration.models.Plane;
import com.example.sdbesoaringadministration.models.TypeOfMembership;

import java.util.List;

public interface TypeOfMembershipService {

    List<TypeOfMembershipDto> getAllTypeOfMemberships();

    TypeOfMembershipDto getTypeOfMembershipById( Long id );

    TypeOfMembership addTypeOfMembership(TypeOfMembershipDto typeOfMembershipDto );

    void deleteTypeOfMembershipById( Long id );

    TypeOfMembershipDto  updateTypeOfMembership( Long id, TypeOfMembershipDto dto );
}
