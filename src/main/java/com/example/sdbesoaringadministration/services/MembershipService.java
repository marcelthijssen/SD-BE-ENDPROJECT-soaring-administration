package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MembershipDto;

import java.util.List;

public interface MembershipService {

    List<MembershipDto> getAllMemberships();

    MembershipDto getMembershipById( Long mbid );

    void addMembership( MembershipDto membershipDto );

    void deleteMembershipById( Long mbid );

    MembershipDto updateMembership( Long mbid, MembershipDto dto );
}
