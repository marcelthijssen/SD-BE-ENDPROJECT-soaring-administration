/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Creates an object of plane
 */

package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity(name = "Plane")
@Table(name = "PLANES")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private String callSign;

    @Column
    private String brand;

    @Column
    private String type;

    @Column(nullable = false, unique = true)
    private String registration;

    @Column
    private Boolean twoSeater;

    @Column
    private Boolean privatePlane;

    @Column
    private BigDecimal minutePrice = BigDecimal.valueOf( 0 );
    @Lob

    @Column
    private byte[] flightStatus;


    @OneToMany
            (mappedBy = "plane",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> flights;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @JsonBackReference("owner")
    @JsonIgnore
    private Person owner;

    @ManyToOne
    @JoinColumn(name = "technician_id")
    @JsonBackReference("technician")
    @JsonIgnore
    private Person technician;

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

    public BigDecimal getMinutePrice() {
        return minutePrice;
    }

    public void setMinutePrice( BigDecimal minutePrice ) {
        this.minutePrice = minutePrice;
    }

    public Boolean getTwoSeater() {
        return twoSeater;
    }

    public void setTwoSeater( Boolean twoSeater ) {
        this.twoSeater = twoSeater;
    }

    public Boolean getPrivatePlane() {
        return privatePlane;
    }

    public void setPrivatePlane( Boolean privatePlane ) {
        this.privatePlane = privatePlane;
    }

    public byte[] getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus( byte[] flightStatus ) {
        this.flightStatus = flightStatus;
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

    public Person getOwner( ) {
        return this.owner;
    }

    public void setOwner( Person owner ) {
        this.owner = owner;
    }

    public Person getTechnician() {
        return technician;
    }

    public void setTechnician( Person technician ) {
        this.technician = technician;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Plane plane = ( Plane ) o;
        return Objects.equals( id, plane.id ) && Objects.equals( callSign, plane.callSign ) && Objects.equals( brand, plane.brand ) && Objects.equals( type, plane.type ) && Objects.equals( registration, plane.registration ) && Objects.equals( twoSeater, plane.twoSeater ) && Objects.equals( privatePlane, plane.privatePlane ) && Objects.equals( minutePrice, plane.minutePrice ) && Arrays.equals( flightStatus, plane.flightStatus ) && Objects.equals( flights, plane.flights ) && Objects.equals( owner, plane.owner ) && Objects.equals( technician, plane.technician );
    }

    @Override
    public int hashCode() {
        int result = Objects.hash( id, callSign, brand, type, registration, twoSeater, privatePlane, minutePrice, flights, owner, technician );
        result = 31 * result + Arrays.hashCode( flightStatus );
        return result;
    }
}
