package com.example.sdbesoaringadministration.dtos;


import com.example.sdbesoaringadministration.models.*;
;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;


@Validated
public class FlightDto {

    private Long id;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private long timeFlown;
    private boolean instructionFlight;
    private String remarks;
    // MayToOne
    private Plane plane;
    private Airport airportStart;
    private Airport airportEnd;
    private StartingMethode startingMethode;
    private Person passenger;
    private Person captain;
    private Person billedPerson;


    public FlightDto() {
    }

    public FlightDto( Long id, LocalDateTime timeStart, LocalDateTime timeEnd, long timeFlown, boolean instructionFlight, String remarks, Plane plane, Airport airportStart, Airport airportEnd, StartingMethode startingMethode,
                      Person passenger, Person captain, Person billedPerson ) {
        this.id = id;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.timeFlown = timeFlown;
        this.instructionFlight = instructionFlight;
        this.remarks = remarks;
        this.plane = plane;
        this.airportStart = airportStart;
        this.airportEnd = airportEnd;
        this.startingMethode = startingMethode;
        this.passenger = passenger;
        this.captain = captain;
        this.billedPerson = billedPerson;
    }


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart( LocalDateTime timeStart ) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd( LocalDateTime timeEnd ) {
        this.timeEnd = timeEnd;
    }

    public long getTimeFlown() {
        return timeFlown;
    }

    public void setTimeFlown( long timeFlown ) {
        this.timeFlown = timeFlown;
    }

    public boolean getInstructionFlight() {
        return instructionFlight;
    }

    public void setInstructionFlight( boolean instructionFlight ) {
        this.instructionFlight = this.instructionFlight;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks( String remarks ) {
        this.remarks = remarks;
    }

    public void setPlane( Plane plane ) {
        this.plane = plane;
    }

    public Plane getPlane() {
        return plane;
    }


    public Airport getAirportStart() {
        return airportStart;
    }

    public void setAirportStart( Airport airportStart ) {
        this.airportStart = airportStart;
    }

    public Airport getAirportEnd() {
        return airportEnd;
    }

    public void setAirportEnd( Airport airportEnd ) {
        this.airportEnd = airportEnd;
    }


    public StartingMethode getStartingMethode() {
        return startingMethode;
    }

    public void setStartingMethode( StartingMethode startingMethode ) {
        this.startingMethode = startingMethode;
    }


    public Person getPassenger() {
        return passenger;
    }

    public void setPassenger( Person passenger ) {
        this.passenger = passenger;
    }

    public Person getCaptain() {
        return captain;
    }

    public void setCaptain( Person captain ) {
        this.captain = captain;
    }

    public Person getBilledPerson() {
        return billedPerson;
    }

    public void setBilledPerson( Person billedPerson ) {
        this.billedPerson = billedPerson;
    }


    public static Flight flightDtoToFlight( FlightDto dto ) {
        Flight fl = new Flight();

        fl.setId( dto.getId() );
        fl.setTimeStart( dto.getTimeStart() );
        fl.setTimeEnd( dto.getTimeEnd() );
        fl.setTimeFlown( dto.getTimeFlown() );
        fl.setInstructionFlight( dto.getInstructionFlight() );
        fl.setRemarks( dto.getRemarks() );
        fl.setPlane( dto.getPlane() );
        fl.setAirportStart( dto.getAirportStart() );
        fl.setAirportEnd( dto.getAirportEnd() );
        fl.setStartingMethode( dto.getStartingMethode() );
        fl.setPassenger( dto.getPassenger() );
        fl.setCaptain( dto.getCaptain() );
        fl.setBilledPerson( dto.getBilledPerson() );

        return fl;
    }


    public FlightDto flightToFlightDto( Flight fl ) {
        FlightDto dto = new FlightDto();

        dto.setId( fl.getId() );
        dto.setTimeStart( fl.getTimeStart() );
        dto.setTimeEnd( fl.getTimeEnd() );
        dto.setTimeFlown( fl.getTimeFlown() );
        dto.setInstructionFlight( fl.getInstructionFlight() );
        dto.setRemarks( fl.getRemarks() );
        dto.setPlane( fl.getPlane() );
        dto.setAirportStart( fl.getAirportStart() );
        dto.setAirportEnd( fl.getAirportEnd() );
        dto.setStartingMethode( fl.getStartingMethode() );
        dto.setPassenger( fl.getPassenger() );
        dto.setCaptain( fl.getCaptain() );
        dto.setBilledPerson( fl.getBilledPerson() );

        return dto;
    }
}
