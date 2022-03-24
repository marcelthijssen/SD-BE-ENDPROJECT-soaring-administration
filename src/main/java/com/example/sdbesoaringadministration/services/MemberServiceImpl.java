package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MemberDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Member;
import com.example.sdbesoaringadministration.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl( MemberRepository memberRepository ) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<Member> memberList = this.memberRepository.findAll();
        List<MemberDto> memberDtoList = new ArrayList<>();

        for ( Member m : memberList ) {
            MemberDto dto = new MemberDto();

            dto.setId( m.getId() );
            dto.setMembership( m.getMembership() );
            dto.setUserName( m.getUserName() );
            dto.setPassword( m.getPassword() );
            dto.setPilotLicense( m.getPilotLicense() );
            dto.setGender( m.getGender() );
            dto.setFirstName( m.getFirstName() );
            dto.setLastName( m.getLastName() );
            dto.setBirthday( m.getBirthday() );
            dto.setStreetName( m.getStreetName() );
            dto.setHouseNumber( m.getHouseNumber() );
            dto.setCity( m.getCity() );
            dto.setCountry( m.getCountry() );
            dto.setEmail( m.getEmail() );
            dto.setPhone( m.getPhone() );
            memberDtoList.add( dto );
        }
        return memberDtoList;
    }


    @Override
    public MemberDto getMemberById( Long id ) {
        MemberDto dto = new MemberDto();

        if ( memberRepository.findById( id ).isPresent() ) {
            Member m = memberRepository.findById( id ).get();
            dto.setId( m.getId() );
            dto.setMembership( m.getMembership() );
            dto.setUserName( m.getUserName() );
            dto.setPassword( m.getPassword() );
            dto.setPilotLicense( m.getPilotLicense() );
            dto.setGender( m.getGender() );
            dto.setFirstName( m.getFirstName() );
            dto.setLastName( m.getLastName() );
            dto.setBirthday( m.getBirthday() );
            dto.setStreetName( m.getStreetName() );
            dto.setHouseNumber( m.getHouseNumber() );
            dto.setCity( m.getCity() );
            dto.setCountry( m.getCountry() );
            dto.setEmail( m.getEmail() );
            dto.setPhone( m.getPhone() );
            return dto;
        } else {
            throw new RecordNotFoundException( "Nu such member" );
        }
    }

    @Override
    public void addMember( MemberDto memberDto ) {
        Member m = new Member();
        m.setId( memberDto.getId() );
        m.setMembership( memberDto.getMembership() );
        m.setUserName( memberDto.getUserName() );
        m.setPassword( memberDto.getPassword() );
        m.setPilotLicense( memberDto.getPilotLicense() );
        m.setGender( memberDto.getGender() );
        m.setFirstName( memberDto.getFirstName() );
        m.setLastName( memberDto.getLastName() );
        m.setBirthday( memberDto.getBirthday() );
        m.setStreetName( memberDto.getStreetName() );
        m.setHouseNumber( memberDto.getHouseNumber() );
        m.setCity( memberDto.getCity() );
        m.setCountry( memberDto.getCountry() );
        m.setEmail( memberDto.getEmail() );
        m.setPhone( memberDto.getPhone() );

        this.memberRepository.save( m );
    }

    @Override
    public void deleteMemberById( Long id ) {
        if ( memberRepository.findById( id ).isPresent() ) {
            memberRepository.deleteById( id );
        } else {
            throw new RecordNotFoundException( "Member not found" );
        }
    }

    @Override
    public MemberDto updateMember( Long id, MemberDto dto ) {
        if ( memberRepository.findById( id ).isPresent() ) {
            Member m = memberRepository.findById( id ).get();

            m.setId( m.getId() );
            m.setMembership( m.getMembership() );
            m.setUserName( m.getUserName() );
            m.setPassword( m.getPassword() );
            m.setPilotLicense( m.getPilotLicense() );
            m.setGender( m.getGender() );
            m.setFirstName( m.getFirstName() );
            m.setLastName( m.getLastName() );
            m.setBirthday( m.getBirthday() );
            m.setStreetName( m.getStreetName() );
            m.setHouseNumber( m.getHouseNumber() );
            m.setCity( m.getCity() );
            m.setCountry( m.getCountry() );
            m.setEmail( m.getEmail() );
            m.setPhone( m.getPhone() );

            memberRepository.save( m );
            return null;
        } else {
            throw new RecordNotFoundException( "Member not found" );
        }
    }
}
