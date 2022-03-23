package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.TypeOfMembershipDto;
import com.example.sdbesoaringadministration.models.TypeOfMembership;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfMembershipServiceImpl implements TypeOfMembershipService {
    @Override
    public List<TypeOfMembershipDto> getAllTypeOfMemberships() {
        return null;
    }

    @Override
    public TypeOfMembershipDto getTypeOfMembershipById(Long id) {
        return null;
    }

    @Override
    public TypeOfMembership addTypeOfMembership(TypeOfMembershipDto typeOfMembershipDto) {
        return null;
    }

    @Override
    public void deleteTypeOfMembershipById(Long id) {

    }

    @Override
    public TypeOfMembershipDto updateTypeOfMembership(Long id, TypeOfMembershipDto dto) {
        return null;
    }
}
