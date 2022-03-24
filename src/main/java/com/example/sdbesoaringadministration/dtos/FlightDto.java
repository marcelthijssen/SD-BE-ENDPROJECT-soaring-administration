package com.example.sdbesoaringadministration.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class FlightDto {

    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String captain;
    private String passenger;

    private boolean instructionFlight;

    private String remarks;

    //TODO: Add StartingMethode and Plane

    public FlightDto() {
    }

    public FlightDto( Long id, LocalDateTime startTime, LocalDateTime endTime, String captain, String passenger, boolean instructionFlight, String remarks ) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.captain = captain;
        this.passenger = passenger;
        this.instructionFlight = instructionFlight;
        this.remarks = remarks;
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


}
