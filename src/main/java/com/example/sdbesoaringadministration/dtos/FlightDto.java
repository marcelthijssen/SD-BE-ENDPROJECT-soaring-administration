package com.example.sdbesoaringadministration.dtos;

import java.util.Date;

public class FlightDto {

    private Long id;

    private Date startTime;
    private Date endTime;

    private String gezagvoerder;
    private String passenger;

    private boolean instructionFlight;

    private String remarks;

    //TODO: Add StartingMethode and Plane

    public FlightDto() {
    }

    public FlightDto( Long id, Date startTime, Date endTime, String gezagvoerder, String passenger, boolean instructionFlight, String remarks ) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.gezagvoerder = gezagvoerder;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime( Date startTime ) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime( Date endTime ) {
        this.endTime = endTime;
    }

    public String getGezagvoerder() {
        return gezagvoerder;
    }

    public void setGezagvoerder( String gezagvoerder ) {
        this.gezagvoerder = gezagvoerder;
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
