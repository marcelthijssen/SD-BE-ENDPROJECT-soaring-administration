package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private long timeFlown;
    private boolean instructionFlight;
    private String remarks;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "billed_person_id",
            referencedColumnName = "id")
    private Person billedPerson;
    //    a plane can have multiple flights
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(
            name = "plane_id",
            referencedColumnName = "id")
    private Plane plane;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(
            name = "starting_methode_id",
            referencedColumnName = "id")
    private StartingMethode startingMethode;

    //    a person can have different relations with the flight
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "passenger_id",
            referencedColumnName = "id")

    private Person passenger;

    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "captain_id",
            referencedColumnName = "id")
    private Person captain;

    //    /    a person can have different relations with the flight
    @ManyToOne
//    @JsonBackReference
    @JoinColumn(name = "airport_end_id",
            referencedColumnName = "id")
    private Airport airportEnd;

    @ManyToOne
    @JoinColumn(name = "airport_start_id",
            referencedColumnName = "id")
    private Airport airportStart;

    @OneToMany
            (mappedBy = "flights_info",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Invoice> flights_info;


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

    public void setPlane( Plane plane ) {
        this.plane = plane;
    }

    public Plane getPlane() {
        return plane;
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

    public Person getBilledPerson() {
        return billedPerson;
    }

    public void setBilledPerson( Person billedPerson ) {
        this.billedPerson = billedPerson;
    }
}
