package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MembershipDto;

import java.util.List;

public interface MembershipService {

    List<MembershipDto> getAllMemberships();

    MembershipDto getMembershipById( Long id );

    void addMembership( MembershipDto membershipDto );

    void deleteMembershipById( Long id );

    MembershipDto updateMembership( Long id, MembershipDto dto );
}
