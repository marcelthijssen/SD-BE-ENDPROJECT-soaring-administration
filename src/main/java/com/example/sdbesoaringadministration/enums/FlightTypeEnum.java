package com.example.sdbesoaringadministration.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FlightTypeEnum {

    INSTRUCTION_FLIGHT( "Instruction flight" ),
    PRIVATE_FLIGHT   ( "Private flight" ),
    CHECK_FLIGHT_MEMBER( "Checkflight pilot" ),
    CHECK_FLIGHT_PLANE( "Checkflight plane" );

    private final String flightTypeName;

    FlightTypeEnum( String flightTypeName ) {
        this.flightTypeName = flightTypeName;
    }


    @JsonValue
     public String getFlightTypeName() {
        return flightTypeName;
    }
}
