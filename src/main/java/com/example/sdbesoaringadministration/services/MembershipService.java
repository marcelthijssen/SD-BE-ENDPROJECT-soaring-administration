/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration.services;

import com.example.sdbesoaringadministration.dtos.MembershipDto;

import java.util.List;

public interface MembershipService {

    List<MembershipDto> getAllMemberships();

    MembershipDto getMembershipById( Long membership_id );

    void createMembership( MembershipDto membershipDto );

    void deleteMembershipById( Long membership_id );

    MembershipDto updateMembership( Long membership_id, MembershipDto dto );
}
