package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "Address")
@Table(name = "ADDRESSES")
public class Address {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
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
    @OneToOne
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

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Address address = ( Address ) o;
        return Objects.equals( id, address.id ) && Objects.equals( streetName, address.streetName ) && Objects.equals( houseNumber, address.houseNumber ) && Objects.equals( postalcode, address.postalcode ) && Objects.equals( city, address.city ) && Objects.equals( country, address.country ) && Objects.equals( person, address.person );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, streetName, houseNumber, postalcode, city, country, person );
    }
}
