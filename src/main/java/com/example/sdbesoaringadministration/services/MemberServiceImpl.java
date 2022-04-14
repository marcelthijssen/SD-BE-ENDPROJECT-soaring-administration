package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MemberDto;
import com.example.sdbesoaringadministration.exceptions.RecordNotFoundException;
import com.example.sdbesoaringadministration.models.Member;
import com.example.sdbesoaringadministration.repositories.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sdbesoaringadministration.dtos.MemberDto.memberDtoToMember;

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
            MemberDto dto = new MemberDto().memberToMemberDto(m);

            memberDtoList.add( dto );
        }
        return memberDtoList;
    }


    @Override
    public MemberDto getMemberById( Long id ) {
//        MemberDto dto = new MemberDto();

        if ( memberRepository.findById( id ).isPresent() ) {
            Member m = memberRepository.findById( id ).get();
            return new MemberDto().memberToMemberDto(m);
        } else {
            throw new RecordNotFoundException( "Nu such member" );
        }
    }

    @Override
    public Member addMember( MemberDto memberDto ) {
        Member member = memberDtoToMember( memberDto );

        memberRepository.save( member );
        return member;
    }

    @Override
    public void deleteMemberById( Long id ) {
        if ( memberRepository.findById( id ).isPresent() ) {
            memberRepository.deleteById( id );
            throw new RecordNotFoundException( "Member deleted from list" );

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
