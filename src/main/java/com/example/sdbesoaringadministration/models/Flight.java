package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
// TODO: calc total time flying
//    @NotBlank
//    @Column(nullable = false)
    private boolean instructionFlight;
    private String remarks;

//    a plane can have multiple flights
    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "plane_id",
            referencedColumnName = "id")
    private Plane plane;

//    a airport can have multiple flights
    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "airport_id",
            referencedColumnName = "id")
    private Airport airport;

    //    a airport can have multiple flights
    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "starting_methode_id",
            referencedColumnName = "id")
    private StartingMethode startingMethode;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "passenger_id",
            referencedColumnName = "id")
    private Person passenger;



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

    public boolean getInstructionFlight() {
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

//   OneTwoMany  plane

    public void setPlane( Plane plane ) {
        this.plane = plane;
    }

    public Plane getPlane() {
        return plane;
    }

// OneToMany Airport

    public void setAirport( Airport airport ) {
        this.airport = airport;
    }

    public Airport getAirport() {
        return airport;
    }

//
    public StartingMethode getStartingMethode() {
        return startingMethode;
    }

    public void setStartingMethode( StartingMethode startingMethode ) {
        this.startingMethode = startingMethode;
    }

    public Person getPerson() {
        return passenger;

    }

    public void setPerson( Person passenger ) {
        this.passenger = passenger;
    }
//
//public Person getCaptain() {return captain;}
//    public void setCaptain( Person captain ) {
//        this.captain = captain;
//    }

}
