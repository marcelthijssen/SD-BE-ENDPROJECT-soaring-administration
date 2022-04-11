package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
@Table(name = "planes")
public class Plane {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    private String callSign;
    private String brand;
    private String type;
    private String registration;
    private boolean twoSeater;
    private boolean privatePlane;

    // A flight can only have on eplane
    @OneToMany
            (mappedBy = "plane",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> flights;

    //     Owner of plane

    @ManyToOne
    @JsonBackReference
    @JoinColumn(
            name = "owner_id",
            referencedColumnName = "id")
    private Person owner;


    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign( String callSign ) {
        this.callSign = callSign;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand( String brand ) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType( String type ) {
        this.type = type;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration( String registration ) {
        this.registration = registration;
    }

    public boolean isTwoSeater() {
        return twoSeater;
    }

    public void setTwoSeater( boolean twoSeater ) {
        this.twoSeater = twoSeater;
    }

    public boolean isPrivatePlane() {
        return privatePlane;
    }

    public void setPrivatePlane( boolean privatePlane ) {
        this.privatePlane = privatePlane;
    }

    // Flight
    public void setFlight( List<Flight> flights ) {
        this.flights = flights;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    void addFlight( Flight flight ) {
        this.flights.add( flight );
    }


}
