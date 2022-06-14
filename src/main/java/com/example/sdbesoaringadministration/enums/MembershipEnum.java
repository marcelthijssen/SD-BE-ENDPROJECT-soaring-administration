package com.example.sdbesoaringadministration.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MembershipEnum {

    MEMBERSHIP_TYPE_1( 1, "Pupil ≤18" ),
    MEMBERSHIP_TYPE_2( 2, "Pupil >18" ),
    MEMBERSHIP_TYPE_3( 3, "GPL ≤18" ),
    MEMBERSHIP_TYPE_4( 4, "Non-flying member" ),
    MEMBERSHIP_TYPE_6( 6, "Honorable member" );

    private final int memberShipTypeNum;
    private final String memberShipTypeName;

    MembershipEnum( int memberShipTypeNum, String memberShipTypeName ) {
        this.memberShipTypeNum = memberShipTypeNum;
        this.memberShipTypeName = memberShipTypeName;
    }

    public int getMemberShipTypeNum() {
        return memberShipTypeNum;
    }

    public String getMemberShipTypeName() {
        return memberShipTypeName;
    }


}
