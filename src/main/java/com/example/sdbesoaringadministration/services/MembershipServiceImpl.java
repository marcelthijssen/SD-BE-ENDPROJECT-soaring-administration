package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MembershipDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Membership;
import com.example.sdbesoaringadministration.repositories.MembershipRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sdbesoaringadministration.dtos.MembershipDto.membershipDtoToMembership;

@Service
public class MembershipServiceImpl implements MembershipService {


    private final MembershipRepository tomRepository;

    public MembershipServiceImpl( MembershipRepository tomRepository ) {
        this.tomRepository = tomRepository;
    }

    @Override
    public List<MembershipDto> getAllMemberships() {
        List<Membership> tomList = this.tomRepository.findAll();
        List<MembershipDto> tomDtoList = new ArrayList<>();

        for ( Membership tom : tomList ) {
            MembershipDto dto = new MembershipDto().membershipToMembershipDto( tom );
            tomDtoList.add( dto );
        }
        return tomDtoList;
    }

    @Override
    public MembershipDto getMembershipById( Long tid ) {
        if ( tomRepository.findById( tid ).isPresent() ) {
            Membership tom = tomRepository.findById( tid ).get();

            return new MembershipDto().membershipToMembershipDto( tom );
        } else {
            throw new RecordNotFoundException( "Type of Membership not found" );
        }
    }

    @Override
    public void createMembership( MembershipDto dto ) {
        Membership tom = membershipDtoToMembership(dto);
        this.tomRepository.save( tom );
    }

    @Override
    public void deleteMembershipById( Long mbid ) {
        if ( tomRepository.findById( mbid ).isPresent() ) {
            tomRepository.deleteById( mbid );
        } else {
            throw new RecordNotFoundException( "Type of Membership not found" );
        }
    }


    @Override
    public MembershipDto updateMembership( Long mbid, MembershipDto dto ) {
        if ( tomRepository.findById( mbid ).isPresent() ) {
            Membership tom = tomRepository.findById( mbid ).get();

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
