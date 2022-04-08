package com.example.sdbesoaringadministration.dtos;


import com.example.sdbesoaringadministration.models.Plane;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class FlightDto {

    private Long id;

    //    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="Europe/Amsterdam")
    private LocalDateTime startTime;

    //    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss", timezone="Europe/Amsterdam")
    private LocalDateTime endTime;
    private String captain;
    private String passenger;
    private boolean instructionFlight;
    private String remarks;

    private Plane plane;
    //TODO: Add StartingMethode and Plane

    public FlightDto() {
    }

    public FlightDto( Long id, LocalDateTime startTime, LocalDateTime endTime, String captain, String passenger, boolean instructionFlight, String remarks, Plane plane ) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.captain = captain;
        this.passenger = passenger;
        this.instructionFlight = instructionFlight;
        this.remarks = remarks;
        this.plane = plane;
    }


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime( LocalDateTime startTime ) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime( LocalDateTime endTime ) {
        this.endTime = endTime;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain( String captain ) {
        this.captain = captain;
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger( String passenger ) {
        this.passenger = passenger;
    }

    public boolean isInstructionFlight() {
        return instructionFlight;
    }

    public void setInstructionFlight( boolean instructionFlight ) {
        this.instructionFlight = instructionFlight;
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

}
