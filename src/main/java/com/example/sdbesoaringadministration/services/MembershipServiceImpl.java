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


    private final MembershipRepository msRepository;

    public MembershipServiceImpl( MembershipRepository msRepository ) {
        this.msRepository = msRepository;
    }

    @Override
    public List<MembershipDto> getAllMemberships() {
        List<Membership> msList = this.msRepository.findAll();
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
            Membership ms = msRepository.findById( msid ).get();
           return membershipToMembershipDto( ms );
        } catch ( RecordNotFoundException e ) {
            throw new RecordNotFoundException( "Invalid membership id: " + msid, HttpStatus.NOT_FOUND );
        }
    }

    @Override
    public void createMembership( MembershipDto dto ) {
        Membership tom = membershipDtoToMembership(dto);
        this.msRepository.save( tom );
    }

    @Override
    public void deleteMembershipById( Long mbid ) {
        if ( msRepository.findById( mbid ).isPresent() ) {
            msRepository.deleteById( mbid );
        } else {
            throw new RecordNotFoundException( "Type of Membership not found", HttpStatus.NOT_FOUND );
        }
    }


    @Override
    public MembershipDto updateMembership( Long mbid, MembershipDto dto ) {
        if ( msRepository.findById( mbid ).isPresent() ) {
            Membership tom = msRepository.findById( mbid ).get();

            tom.setId( tom.getId() );
            tom.setTitle( dto.getTitle() );
            tom.setCostsPerMonth( dto.getCostsPerMonth() );
            msRepository.save( tom );
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
