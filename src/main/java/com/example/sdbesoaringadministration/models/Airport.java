package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "airports")
public class Airport {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String Icao;
    private String location;

    // A flight can only have on airport
    @OneToMany
            (mappedBy = "airportStart",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> airportStart;

    @OneToMany
            (mappedBy = "airportEnd",
                    fetch= FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> airportEnd;


//    GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation( String location ) {
        this.location = location;
    }

    public String getIcao() {
        return Icao;
    }

    public void setIcao( String Icao ) {
        this.Icao = Icao;
    }

    // Flight
//    public void setFlight(List<Flight> flights) {
//        this.flights = flights;
//    }
//    public List<Flight> getFlights() {
//        return flights;
//    }
//
//    void addFlight( Flight flight) {
//        this.flights.add(flight);
//    }


}
