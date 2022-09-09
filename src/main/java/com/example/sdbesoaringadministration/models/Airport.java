/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 *
 * Creates an object of Airport
 *
 */

package com.example.sdbesoaringadministration.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "Airport")
@Table(name = "AIRPORTS")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String icao;

    @Column
    private String city;

    @Column
    private String country;

    @OneToMany
            (mappedBy = "airportStart",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> airportStart;

    @OneToMany
            (mappedBy = "airportEnd",
                    fetch = FetchType.LAZY,
                    cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Flight> airportEnd;

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getIcao() {
        return icao;
    }

    public void setIcao( String icao ) {
        this.icao = icao;
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

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        Airport airport = ( Airport ) o;
        return Objects.equals( id, airport.id ) && Objects.equals( icao, airport.icao ) && Objects.equals( city, airport.city ) && Objects.equals( country, airport.country ) && Objects.equals( airportStart, airport.airportStart ) && Objects.equals( airportEnd, airport.airportEnd );
    }

    @Override
    public int hashCode() {
        return Objects.hash( id, icao, city, country, airportStart, airportEnd );
    }


}
