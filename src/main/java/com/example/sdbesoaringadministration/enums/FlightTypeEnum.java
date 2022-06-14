package com.example.sdbesoaringadministration.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FlightTypeEnum {
    FLIGHT_TYPE_1( 1, "Checkflight plane" ),
    FLIGHT_TYPE_2( 2, "Instruction flight" ),
    FLIGHT_TYPE_3( 3, "Private flight" ),
    FLIGHT_TYPE_4( 4, "Checkflight pilot" );

    private final int flightTypeNum;
    private final String flightTypeName;

    FlightTypeEnum( int flightTypeNum, String flightTypeName ) {
        this.flightTypeNum = flightTypeNum;
        this.flightTypeName = flightTypeName;
    }

    public int getFlightTypeNum() {
        return flightTypeNum;
    }

    @JsonValue
     public String getFlightTypeName() {
        return flightTypeName;
    }
}
