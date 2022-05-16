package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

public class Address extends Person {

    @Column
    private Long id;
    @Column
    private String streetName;

    @Column
    private String houseNumber;

    @Column
    private String postalcode;

    @Column
    private String city;

    @Column
    private String country;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Person person;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName( String streetName ) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber( String houseNumber ) {
        this.houseNumber = houseNumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode( String postalcode ) {
        this.postalcode = postalcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry( String country ) {
        this.country = country;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson( Person person ) {
        this.person = person;
    }
}
