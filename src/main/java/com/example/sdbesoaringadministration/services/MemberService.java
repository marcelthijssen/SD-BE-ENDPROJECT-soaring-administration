package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MemberDto;
import com.example.sdbesoaringadministration.models.Member;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberService {
    List<MemberDto> getAllMembers();

    MemberDto getMemberById( Long id );

    Member addMember( MemberDto memberDto );

    void deleteMemberById( Long id );

    MemberDto updateMember( Long id, MemberDto dto );

}
