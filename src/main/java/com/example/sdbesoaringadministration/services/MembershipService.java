/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MembershipDto;

import java.util.List;

public interface MembershipService {

    List<MembershipDto> getAllMemberships();

    MembershipDto getMembershipById( Long mbid );

    void createMembership( MembershipDto membershipDto );

    void deleteMembershipById( Long mbid );

    MembershipDto updateMembership( Long mbid, MembershipDto dto );
}
