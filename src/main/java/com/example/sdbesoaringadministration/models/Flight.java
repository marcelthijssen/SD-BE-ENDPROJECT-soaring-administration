package com.example.sdbesoaringadministration.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private Date startTime;
    private Date endTime;

    private String gezagvoerder;
    private String passenger;

    private boolean instructionFlight;

    private String remarks;

    @ManyToOne
    @JoinColumn(name = "plane_id")
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "starting_methode_id")
    private StartingMethode startingMethode;


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

    public Plane getPlane() {
        return plane;
    }

    public void setPlane( Plane plane ) {
        this.plane = plane;
    }

    public StartingMethode getStartingMethode() {
        return startingMethode;
    }

    public void setStartingMethode( StartingMethode startingMethode ) {
        this.startingMethode = startingMethode;
    }
}
