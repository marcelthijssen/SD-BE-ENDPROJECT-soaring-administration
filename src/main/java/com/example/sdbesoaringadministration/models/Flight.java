package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

//    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
    private LocalDateTime timeStart = LocalDateTime.now();

//    @CreationTimestamp
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", shape = JsonFormat.Shape.STRING)
    private LocalDateTime timeEnd;

    private long timeFlown;
    private boolean instructionFlight;
    private String remarks;

//    a plane can have multiple flights
    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "plane_id",
            referencedColumnName = "id")
    private Plane plane;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "starting_methode_id",
            referencedColumnName = "id")
    private StartingMethode startingMethode;

//    a person can have different relations with the flight
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    @JsonBackReference("passenger")
    private Person passenger;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    @JsonBackReference("captain")
    private Person captain;

//    /    a person can have different relations with the flight
    @ManyToOne
    @JoinColumn(name = "airport_end_id")
    @JsonBackReference("airportEnd")
    private Airport airportEnd;

    @ManyToOne
    @JoinColumn(name = "airport_start_id")
    @JsonBackReference("airportStart")
    private Airport airportStart;


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


//
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
// OneToMany Airport


    public Airport getAirportStart() {
        return airportStart;
    }

    public Airport getAirportEnd() {
        return airportEnd;
    }

    public void setAirportEnd( Airport airportEnd ) {
        this.airportEnd = airportEnd;
    }

    public void setAirportStart( Airport airportStart ) {
        this.airportStart = airportStart;
    }



}
