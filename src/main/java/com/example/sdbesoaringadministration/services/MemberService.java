package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MemberDto;

import java.util.List;

public interface MemberService {
    List<MemberDto> getAllMembers();

    MemberDto getMemberById( Long id );

    void addMember( MemberDto memberDto );

    void deleteMemberById( Long id );

    MemberDto updateMember( Long id, MemberDto dto );

}
