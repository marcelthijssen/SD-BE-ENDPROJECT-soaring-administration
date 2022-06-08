/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Implements methodes for MembershipsController
 *
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MembershipDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Membership;
import com.example.sdbesoaringadministration.repositories.MembershipRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {


    private final MembershipRepository membershipRepository;

    public MembershipServiceImpl( MembershipRepository membershipRepository ) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public List<MembershipDto> getAllMemberships() {
        List<Membership> msList = this.membershipRepository.findAll();
        List<MembershipDto> tomDtoList = new ArrayList<>();

        for ( Membership tom : msList ) {
            MembershipDto dto = membershipToMembershipDto( tom );
            tomDtoList.add( dto );
        }
        return tomDtoList;
    }

    @Override
    public MembershipDto getMembershipById( Long msid ) {
       try {
            Membership ms = membershipRepository.findById( msid ).get();
           return membershipToMembershipDto( ms );
        } catch ( RecordNotFoundException e ) {
            throw new RecordNotFoundException( "Invalid membership id: " + msid, HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public void createMembership( MembershipDto dto ) {
        Membership tom = membershipDtoToMembership(dto);
        this.membershipRepository.save( tom );
    }

    @Override
    public void deleteMembershipById( Long membership_id ) {
        if ( membershipRepository.findById( membership_id ).isPresent() ) {
            membershipRepository.deleteById( membership_id );
        } else {
            throw new RecordNotFoundException( "Type of Membership not found", HttpStatus.NOT_FOUND );
        }
    }


    @Override
    public MembershipDto updateMembership( Long membership_id, MembershipDto dto ) {
        if ( membershipRepository.findById( membership_id ).isPresent() ) {
            Membership tom = membershipRepository.findById( membership_id ).get();

            tom.setId( tom.getId() );
            tom.setTitle( dto.getTitle() );
            tom.setCostsPerMonth( dto.getCostsPerMonth() );
            membershipRepository.save( tom );
        } else {
            throw new RecordNotFoundException( "Type of membership not found", HttpStatus.NOT_FOUND );
        }
        return null;
    }

    public static Membership membershipDtoToMembership( MembershipDto dto ) {
        Membership tom = new Membership();

        tom.setId( dto.getId() );
        tom.setTitle( dto.getTitle() );
        tom.setCostsPerMonth( dto.getCostsPerMonth() );

        return tom;
    }

    public static MembershipDto membershipToMembershipDto( Membership tom ) {
        MembershipDto dto = new MembershipDto();

        dto.setId( tom.getId() );
        dto.setTitle( tom.getTitle() );
        dto.setCostsPerMonth( tom.getCostsPerMonth() );

        return dto;
    }
}
